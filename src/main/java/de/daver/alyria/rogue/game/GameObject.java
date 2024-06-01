package de.daver.alyria.rogue.game;

import de.daver.alyria.rogue.gui.RenderObject;

import java.util.UUID;

public class GameObject {

    private final UUID uuid;
    private final RenderObject renderObject;

    private float x;
    private float y;

    private float velocityX;
    private float velocityY;

    public GameObject(UUID uuid, RenderObject renderObject) {
        this.uuid = uuid;
        this.renderObject = renderObject;
    }

    public void show() {
        Game.get().window().renderer().addObject(this.uuid, this.renderObject);
    }

    public void hide() {
        Game.get().window().renderer().removeObject(this.uuid);
    }

    public UUID uuid() {
        return this.uuid;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        renderObject.setPosition(CoordinateConverter.gameToViewX(this.x), CoordinateConverter.gameToViewY(this.y));
    }

    public void move() {
        setPosition(this.x + velocityX, this.y + velocityY);
    }

    public void setVelocity(float x, float y) {
        this.velocityX = x;
        this.velocityY = y;
    }

    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }

    public float x() {
        return this.x;
    }

    public float y() {
        return this.y;
    }

    public void tick() {
        move();
    }

    interface CoordinateConverter {

        //TODO Functions to convert between world and view coordinates

        static int gameToViewX(float x) {
            return (int) x;
        }

        static int gameToViewY(float y) {
            return (int) y;
        }

        static float viewToGameX(float x) {
            return (float) x;
        }

        static float viewToGameY(float y) {
            return (float) y;
        }

    }
}
