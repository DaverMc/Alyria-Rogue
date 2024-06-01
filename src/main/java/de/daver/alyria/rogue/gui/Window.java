package de.daver.alyria.rogue.gui;

import de.daver.alyria.rogue.game.Game;
import de.daver.alyria.rogue.gui.io.Keyboard;
import de.daver.alyria.rogue.gui.io.Mouse;

import javax.swing.*;

public class Window {

    private final RenderedFrame frame;
    private final Keyboard keyboard;
    private final Mouse mouse;

    public Window(int width, int height) {
        this.frame = new RenderedFrame();
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.addWindowListener(new CloseOperation(this::onWindowClose));
        this.frame.setSize(width, height);
        this.frame.setLocationRelativeTo(null);

        this.keyboard = new Keyboard();
        this.frame.addKeyListener(keyboard);

        this.mouse = new Mouse();
        this.frame.addMouseListener(mouse);
    }

    private void onWindowClose() {
        Game.get().stop();
    }

    public void show() {
        frame.setVisible(true);
    }

    public int width() {
        return frame.getWidth();
    }

    public int height() {
        return frame.getHeight();
    }

    public void update() {
        this.frame.repaint();
    }

    public Renderer renderer() {
        return this.frame.renderer;
    }

    public Keyboard keyboard() {
        return this.keyboard;
    }

    public Mouse mouse() {
        return this.mouse;
    }

}
