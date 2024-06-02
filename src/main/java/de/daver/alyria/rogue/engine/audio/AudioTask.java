package de.daver.alyria.rogue.engine.audio;

import java.util.concurrent.Future;

public record AudioTask(AudioClip audioClip, Future<?> task) {
}
