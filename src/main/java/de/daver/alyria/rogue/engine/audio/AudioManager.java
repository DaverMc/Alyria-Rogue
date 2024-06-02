package de.daver.alyria.rogue.engine.audio;

import de.daver.alyria.rogue.engine.util.Ressource;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AudioManager {

    private static AudioManager instance;

    private final Map<Lane, AudioTask> laneTasks;
    private final ExecutorService threadPool;

    private AudioManager() {
        this.threadPool = Executors.newCachedThreadPool();
        this.laneTasks = new HashMap<>();
    }

    protected Map<Lane, AudioTask> getLaneTasks() {
        return laneTasks;
    }

    protected ExecutorService getThreadPool() {
        return threadPool;
    }

    public AudioClip loadRessource(String ressource) {
        try {
            return loadClip(AudioSystem.getAudioInputStream(Ressource.asStream(ressource)));
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace(); //TODO Logging
            return null;
        }
    }

    public AudioClip loadFile(File file)  {
        try {
            return loadClip(AudioSystem.getAudioInputStream(file));
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace(); //TODO Logging
            return null;
        }
    }

    private AudioClip loadClip(AudioInputStream audioStream) throws LineUnavailableException {
        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);

        Clip clip = (Clip) AudioSystem.getLine(info);
        return new AudioClip(this, clip, audioStream);
    }

    //SECTION Static Methods

    public static AudioManager get() {
        if (instance == null) instance = new AudioManager();
        return instance;
    }
}
