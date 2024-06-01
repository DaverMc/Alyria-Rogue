package de.daver.alyria.rogue.engine.gui;

import javax.swing.*;

class RenderedFrame extends JFrame {

    private final ImagePanel panel;
    private final Renderer renderer;

    public RenderedFrame() {
        this.renderer = new Renderer();
        this.panel = new ImagePanel(renderer::renderView);
        setContentPane(this.panel);
    }

    public ImagePanel panel() {
        return this.panel;
    }

    public Renderer renderer() {
        return this.renderer;
    }
}
