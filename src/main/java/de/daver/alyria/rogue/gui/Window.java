package de.daver.alyria.rogue.gui;

import de.daver.alyria.rogue.game.Game;

import javax.swing.*;
import java.awt.*;

public class Window {

    private final RenderedFrame frame;
    private final Keyboard keyboard;

    public Window(int width, int height) {
        this.frame = new RenderedFrame();
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.addWindowListener(new CloseOperation(this::onWindowClose));
        this.frame.setSize(width, height);
        this.frame.setLocationRelativeTo(null);

        this.keyboard = new Keyboard();
        this.frame.addKeyListener(keyboard);
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

    private static class RenderedFrame extends JFrame {

        private final Renderer renderer;

        public RenderedFrame() {
            this.renderer = new Renderer();
            setContentPane(new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(renderer.renderView(), 0, 0, null);
                }
            });
        }
    }
}
