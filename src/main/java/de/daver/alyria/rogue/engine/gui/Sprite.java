package de.daver.alyria.rogue.engine.gui;

import de.daver.alyria.rogue.engine.util.ImageUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class Sprite {

    private final int width;
    private final int height;
    private final int[] pixels;

    public static Sprite fromRessource(String path) throws IOException {
        return new Sprite(ImageIO.read(Objects.requireNonNull(Sprite.class.getClassLoader().getResource(path))));
    }

    public static Sprite fromFile(File file) throws IOException {
        return new Sprite(ImageIO.read(file));
    }

    public static Sprite fromFile(String path) throws IOException {
        return fromFile(new File(path));
    }

    protected Sprite(BufferedImage image) {
        BufferedImage imageARGB = ImageUtils.convertType(image, BufferedImage.TYPE_INT_ARGB);
        this.width = imageARGB.getWidth();
        this.height = imageARGB.getHeight();
        Raster raster = imageARGB.getRaster();
        this.pixels = ((DataBufferInt) raster.getDataBuffer()).getData();
    }

    public int[] pixels() {
        return this.pixels;
    }

    public int width() {
        return this.width;
    }

    public int height() {
        return this.height;
    }

}