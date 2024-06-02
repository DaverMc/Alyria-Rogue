package de.daver.alyria.rogue.engine.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AudioClip {

    private final AudioManager manager;
    private final Clip clip;
    private final AudioInputStream stream;

    private int startFrame;
    private int endFrame;

    protected AudioClip(AudioManager manager, Clip clip, AudioInputStream stream) {
        this.clip = clip;
        this.stream = stream;
        this.manager = manager;
        this.startFrame = 0;
        this.endFrame = -1;
    }

    private void open() throws LineUnavailableException, IOException {
        clip.open(stream);
    }

    private void close() throws IOException {
        clip.close();
        stream.close();
    }

    public AudioClip setStart(long delay, TimeUnit unit) {
        float frameRate = stream.getFormat().getFrameRate();
        startFrame = (int) (unit.toSeconds(delay) * frameRate);
        return this;
    }

    public AudioClip setEnd(long delay, TimeUnit unit) {
        float frameRate = stream.getFormat().getFrameRate();
        endFrame = (int) (unit.toSeconds(delay) * frameRate);
        return this;
    }

    public void play(Lane lane) {
        AudioTask task = manager.getLaneTasks().remove(lane);
        if (task != null) removeOld(task);

        Future<?> future = manager.getThreadPool().submit(() -> {
            try {
                open();
                clip.setFramePosition(startFrame);
                clip.start();
                while (!clip.isRunning()); //Wait initializing
                //while(clip.isRunning());
                while ((endFrame == -1 || clip.getFramePosition() < endFrame) && clip.isRunning()); //playing
                clip.close();
            }catch (IOException | LineUnavailableException e) {
                e.printStackTrace(); //TODO Logging
            }
        });
        task = new AudioTask(this, future);
        manager.getLaneTasks().put(lane, task);
    }

    private void removeOld(AudioTask task) {
        if (task.audioClip().clip.isOpen()) {
            task.audioClip().clip.stop();
            try {
                task.audioClip().close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            task.audioClip().clip.stop();
            task.task().cancel(true);
        }
    }
}
