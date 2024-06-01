package de.daver.alyria.rogue;

import de.daver.alyria.rogue.game.Game;
import de.daver.alyria.rogue.game.GameObject;
import de.daver.alyria.rogue.gui.RenderObject;
import de.daver.alyria.rogue.gui.Sprite;

import java.awt.*;
import java.util.Arrays;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Game game = Game.get();
        initTest(game);
        game.start();
        while(game.run());
        game.save();
    }

    private static void initTest(Game game) {
        int[] pixels = new int[100];
        Arrays.fill(pixels, Color.RED.getRGB());
        Sprite redSprite = new Sprite(10, 10, pixels);
        RenderObject redRender = new RenderObject(redSprite);
        GameObject red = new GameObject(UUID.randomUUID(), redRender);
        game.addObject(red);
        red.show();
    }

}
