package de.daver.alyria.rogue.engine.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.function.Supplier;

public class ImagePanel extends JPanel {

    private final Supplier<BufferedImage> imageSupplier;

    public ImagePanel(Supplier<BufferedImage> imageSupplier) {
        this.imageSupplier = imageSupplier;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageSupplier.get(), 0, 0, null);
    }

}
