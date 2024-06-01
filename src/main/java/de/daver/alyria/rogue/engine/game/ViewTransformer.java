package de.daver.alyria.rogue.engine.game;

public class ViewTransformer {

    private final float scaleX;
    private final float scaleY;

    public ViewTransformer(float viewWidth, float viewHeight, float gameWidth, float gameHeight) {
        this.scaleX = viewWidth / gameWidth;
        this.scaleY = viewHeight / gameHeight;
    }

    public int gameToViewX(float x) {
        return (int) (x * scaleX);
    }

    public int gameToViewY(float y) {
        return (int) (y * scaleY);
    }

    public float viewToGameX(float x) {
        return x / scaleX;
    }

    public float viewToGameY(float y) {
        return y / scaleY;
    }
}
