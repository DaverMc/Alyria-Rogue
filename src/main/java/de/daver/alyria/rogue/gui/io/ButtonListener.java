package de.daver.alyria.rogue.gui.io;

public interface ButtonListener {

    default void onPressed(Mouse mouse) {}

    default void onReleased(Mouse mouse) {}

    default void onHold(Mouse mouse) {}

    default long holdingDelay() {
        return -1;
    }

}