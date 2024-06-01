package de.daver.alyria.rogue.engine.io;

import de.daver.alyria.rogue.engine.util.Ressource;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioTools {

    public static void playFile(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        play(AudioSystem.getAudioInputStream(file));
    }

    public static void playRessource(String ressource) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        play(AudioSystem.getAudioInputStream(Ressource.asStream(ressource)));
    }

    public static void play(AudioInputStream audioStream) throws IOException, LineUnavailableException, InterruptedException {
        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);

        Clip clip = (Clip) AudioSystem.getLine(info);
        clip.open(audioStream);
        clip.start();

        // Warten bis der Sound zu Ende ist
        while (!clip.isRunning())
            Thread.sleep(10);
        while (clip.isRunning())
            Thread.sleep(10);

        // Ressourcen freigeben
        clip.close();
        audioStream.close();
    }

}
