package de.daver.alyria.rogue.engine.gui;

import java.util.HashMap;
import java.util.Map;

public class RenderObject {

    private final Sprite defaultSprite;
    private final Map<String, Sprite> spriteMap;
    private final Map<String, Animation> animationMap;

    private Sprite currentSprite;
    private Animation currentAnimation;
    private int x; //Coordinate in Gui View of upper left corner
    private int y; //Coordinate in Gui View of upper left corner
    private int width; //Width of currently rendered
    private int height; //Height of currently rendered

    public RenderObject(Sprite defaultSprite) {
        this.defaultSprite = defaultSprite;
        this.spriteMap = new HashMap<>();
        this.spriteMap.put("default", defaultSprite);
        this.animationMap = new HashMap<>();
        this.currentSprite = this.defaultSprite;
    }

    public void renderAnimation(String id) {
        this.currentAnimation = this.animationMap.get(id);
    }

    public int[] render() {
        if (this.currentSprite == null) this.currentSprite = this.defaultSprite;
        Sprite renderSprite = this.currentSprite;

        if(this.currentAnimation != null) renderSprite = this.currentAnimation.animate(renderSprite);

        this.width = renderSprite.width();
        this.height = renderSprite.height();

        return renderSprite.pixels();
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public int width() {
        return this.width;
    }

    public int height() {
        return this.height;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
