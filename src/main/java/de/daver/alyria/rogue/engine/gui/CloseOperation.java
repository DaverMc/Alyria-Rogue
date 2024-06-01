package de.daver.alyria.rogue.engine.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CloseOperation extends WindowAdapter {

    private final Runnable runnable;

    public CloseOperation(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        runnable.run();
    }
}
