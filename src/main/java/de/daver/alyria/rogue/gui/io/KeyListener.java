package de.daver.alyria.rogue.gui.io;

public interface KeyListener {

    default void onPressed(Keyboard keyboard) {}

    default void onReleased(Keyboard keyboard) {}

    default void onHold(Keyboard keyboard) {}

    default long holdingDelay() {
        return -1;
    } //Delay between holding triggers do 0 or lower to disable hold function

}
