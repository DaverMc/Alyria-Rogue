package de.daver.alyria.rogue.engine.audio;

public enum Lanes implements Lane {

    MUSIC("music", "Music"),
    AMBIENT("ambient", "Ambient"),
    EFFECT("effect", "Effect"),
    DIALOGUE("dialogue", "Dialogue"),
    UI("ui", "UI"),
    FOOTSTEPS("footsteps", "Footsteps");

    private final String id;
    private final String name;

    Lanes(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
