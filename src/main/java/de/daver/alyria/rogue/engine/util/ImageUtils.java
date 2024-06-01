package de.daver.alyria.rogue.engine.util;

import de.daver.alyria.rogue.engine.game.Game;
import de.daver.alyria.rogue.engine.gui.Window;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class ImageUtils {

    private ImageUtils() {}

    public static BufferedImage scale(BufferedImage unscaled) {
        Window window = Game.get().window();
        double scaleX = (double) window.width() / unscaled.getWidth();
        double scaleY = (double) window.height() / unscaled.getHeight();
        AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
        AffineTransformOp scaleOperation = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);
        return scaleOperation.filter(unscaled, null);
    }

    public static BufferedImage convertType(BufferedImage image, int type) {
        if (image.getType() == type) return image;

        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), type);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }

}
