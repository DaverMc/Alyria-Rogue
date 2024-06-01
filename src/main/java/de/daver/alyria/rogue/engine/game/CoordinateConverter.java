package de.daver.alyria.rogue.engine.game;

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
