package de.daver.alyria.rogue.engine.gui;

import javax.swing.*;
import java.awt.*;

class RenderedFrame extends JFrame {

    final Renderer renderer;

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
