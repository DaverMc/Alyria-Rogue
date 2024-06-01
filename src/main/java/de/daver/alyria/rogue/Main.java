package de.daver.alyria.rogue;

import de.daver.alyria.rogue.engine.game.Game;
import de.daver.alyria.rogue.engine.game.GameObject;
import de.daver.alyria.rogue.engine.gui.RenderObject;
import de.daver.alyria.rogue.engine.gui.Sprite;
import de.daver.alyria.rogue.engine.io.*;

import java.awt.event.MouseEvent;
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
        GameObject hero;
        try {
            Sprite heroSprite = Sprite.fromRessource("hero.png");
            RenderObject heroRender = new RenderObject(heroSprite);
            hero = new GameObject(UUID.randomUUID(), heroRender);
            game.addObject(hero);
            hero.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        float speed = 10.0f;
        var keyboard = Game.get().window().keyboard();

        keyboard.setKeyListener(Keys.VK_W, new KeyListener() {
            @Override
            public void onPressed(Keyboard kb) {
                hero.setVelocityY(-speed);
            }

            @Override
            public void onReleased(Keyboard kb) {
                if(!kb.isKeyPressed(Keys.VK_S)) hero.setVelocityY(0);
            }
        });

        keyboard.setKeyListener(Keys.VK_S, new KeyListener() {
            @Override
            public void onPressed(Keyboard kb) {
                hero.setVelocityY(speed);
            }

            @Override
            public void onReleased(Keyboard kb) {
                if(!kb.isKeyPressed(Keys.VK_W)) hero.setVelocityY(0);
            }
        });

        keyboard.setKeyListener(Keys.VK_A, new KeyListener() {
            @Override
            public void onPressed(Keyboard kb) {
                hero.setVelocityX(-speed);
            }

            @Override
            public void onReleased(Keyboard kb) {
                if(!kb.isKeyPressed(Keys.VK_D)) hero.setVelocityX(0);
            }
        });

        keyboard.setKeyListener(Keys.VK_D, new KeyListener() {
            @Override
            public void onPressed(Keyboard kb) {
                hero.setVelocityX(speed);
            }

            @Override
            public void onReleased(Keyboard kb) {
                if(!kb.isKeyPressed(Keys.VK_A)) hero.setVelocityX(0);
            }
        });

        var mouse = Game.get().window().mouse();

        mouse.addListener(MouseEvent.BUTTON1, new ButtonListener() {
            @Override
            public void onPressed(Mouse mouse) {
                hero.setPosition(mouse.x(), mouse.y());
            }
        });

        mouse.setMouseWheelListener(System.out::println);
    }

}
