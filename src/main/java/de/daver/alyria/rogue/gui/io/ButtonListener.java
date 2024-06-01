package de.daver.alyria.rogue.gui.io;

public interface ButtonListener {

    void onPressed();

    void onReleased();

    void onHold();

    long holdingDelay();

}
