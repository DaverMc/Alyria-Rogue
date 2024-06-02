package de.daver.alyria.rogue.engine.image;

import de.daver.alyria.rogue.engine.util.Ressource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageWrapper {

    private BufferedImage image;

    private ImageWrapper(BufferedImage image) {
        this.image = image;
    }

    public ImageWrapper scale(double scaleX, double scaleY) {
        AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
        AffineTransformOp scaleOperation = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);
        this.image = scaleOperation.filter(image, null);
        return this;
    }

    public ImageWrapper resize(int width, int height) {
        double scaleX = (double) width / image.getWidth();
        double scaleY = (double) height / image.getHeight();
        return scale(scaleX, scaleY);
    }

    public ImageWrapper type(ImageType type) {
        if (image.getType() == type.getCode()) return this;
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), type.getCode());
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        this.image = newImage;
        return this;
    }

    public BufferedImage unwrap() {
        return image;
    }

    public static ImageWrapper wrap(BufferedImage image) {
        return new ImageWrapper(image);
    }

    public static ImageWrapper wrap(File file) throws IOException{
        return wrap(ImageIO.read(file));
    }

    public static ImageWrapper wrap(String ressource) throws IOException{
        return wrap(ImageIO.read(Ressource.asStream(ressource)));
    }

}
