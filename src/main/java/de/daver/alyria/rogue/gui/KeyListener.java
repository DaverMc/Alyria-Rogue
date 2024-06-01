package de.daver.alyria.rogue.gui;

public interface KeyListener {

    void onPressed();

    void onRelease();

    void onHold();

    long holdDelay(); //Delay between holding triggers do 0 or lower to disable hold function

}
