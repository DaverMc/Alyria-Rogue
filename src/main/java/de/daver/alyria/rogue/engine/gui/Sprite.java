package de.daver.alyria.rogue.engine.gui;

import de.daver.alyria.rogue.engine.image.ImageType;
import de.daver.alyria.rogue.engine.image.ImageWrapper;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;


public class Sprite {

    private final int width;
    private final int height;
    private final int[] pixels;

    public Sprite(ImageWrapper imageWrapper) {
        BufferedImage imageARGB = imageWrapper.type(ImageType.INT_ARGB).unwrap();

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