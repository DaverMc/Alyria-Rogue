package de.daver.alyria.rogue.engine.log;

public interface Level {

    int getWeight();

    String getPrefix();

    String getName();
}
