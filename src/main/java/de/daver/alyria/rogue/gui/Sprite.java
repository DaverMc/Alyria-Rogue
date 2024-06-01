package de.daver.alyria.rogue.gui;

public class Sprite {

    private final int width;
    private final int height;

    private final int[] pixels;

    public Sprite(int width, int height) {
        this(width, height, new int[width * height]);
    }

    public Sprite(int width, int height, int[] pixels) {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
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
