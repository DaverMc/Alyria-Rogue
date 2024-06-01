package de.daver.alyria.rogue;

import de.daver.alyria.rogue.engine.game.Game;
import de.daver.alyria.rogue.engine.game.GameObject;
import de.daver.alyria.rogue.engine.io.ButtonListener;
import de.daver.alyria.rogue.engine.io.KeyListener;
import de.daver.alyria.rogue.engine.gui.RenderObject;
import de.daver.alyria.rogue.engine.gui.Sprite;
import de.daver.alyria.rogue.engine.io.Keyboard;
import de.daver.alyria.rogue.engine.io.Mouse;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Game game = Game.get();
        initTest(game);
        if(!game.start()) {
            System.out.println("Game can't start"); //TODO Logging
            return;
        }
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

        var keyboard = Game.get().window().keyboard();

        keyboard.setKeyListener(KeyEvent.VK_W, new KeyListener() {
            @Override
            public void onPressed(Keyboard kb) {
                red.setVelocityY(-1.0f);
            }

            @Override
            public void onReleased(Keyboard kb) {
                red.setVelocityY(0);
            }
        });

        keyboard.setKeyListener(KeyEvent.VK_S, new KeyListener() {
            @Override
            public void onPressed(Keyboard kb) {
                red.setVelocityY(1.0f);
            }

            @Override
            public void onReleased(Keyboard kb) {
                red.setVelocityY(0);
            }
        });

        keyboard.setKeyListener(KeyEvent.VK_A, new KeyListener() {
            @Override
            public void onPressed(Keyboard kb) {
                red.setVelocityX(-1.0f);
            }

            @Override
            public void onReleased(Keyboard kb) {
                red.setVelocityX(0);
            }
        });

        keyboard.setKeyListener(KeyEvent.VK_D, new KeyListener() {
            @Override
            public void onPressed(Keyboard kb) {
                red.setVelocityX(1.0f);
            }

            @Override
            public void onReleased(Keyboard kb) {
                red.setVelocityX(0);
            }
        });

        Game.get().window().mouse().addListener(MouseEvent.BUTTON1, new ButtonListener() {
            @Override
            public void onPressed(Mouse mouse) {
                red.setPosition(mouse.x(), mouse.y());
            }
        });
    }

}
