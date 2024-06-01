package de.daver.alyria.rogue.game;

import de.daver.alyria.rogue.gui.RenderObject;

import java.util.UUID;

public class GameObject {

    private final UUID uuid;
    private final RenderObject renderObject;

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

}
