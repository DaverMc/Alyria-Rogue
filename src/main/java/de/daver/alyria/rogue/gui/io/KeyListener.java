package de.daver.alyria.rogue.gui.io;

public interface KeyListener {

    void onPressed();

    void onReleased();

    void onHold();

    long holdingDelay(); //Delay between holding triggers do 0 or lower to disable hold function

}
