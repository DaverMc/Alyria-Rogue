package de.daver.alyria.rogue;

import de.daver.alyria.rogue.engine.audio.AudioManager;
import de.daver.alyria.rogue.engine.audio.Lanes;
import de.daver.alyria.rogue.engine.game.Game;
import de.daver.alyria.rogue.engine.game.GameObject;
import de.daver.alyria.rogue.engine.gui.RenderObject;
import de.daver.alyria.rogue.engine.gui.Sprite;
import de.daver.alyria.rogue.engine.gui.input.*;
import de.daver.alyria.rogue.engine.image.ImageWrapper;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

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
            Sprite heroSprite = new Sprite(ImageWrapper.wrap("sprites/hero.png"));
            RenderObject heroRender = new RenderObject(heroSprite);
            hero = new GameObject(UUID.randomUUID(), heroRender);
            game.addObject(hero);
            hero.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        float speed = 10.0f;
        var keyboard = Game.get().window().keyboard();

        keyboard.setKeyListener(Key.VK_W, new KeyListener() {
            @Override
            public void onPressed(Keyboard kb) {
                hero.setVelocityY(-speed);
            }

            @Override
            public void onReleased(Keyboard kb) {
                if(!kb.isKeyPressed(Key.VK_S)) hero.setVelocityY(0);
            }
        });

        keyboard.setKeyListener(Key.VK_S, new KeyListener() {
            @Override
            public void onPressed(Keyboard kb) {
                hero.setVelocityY(speed);
            }

            @Override
            public void onReleased(Keyboard kb) {
                if(!kb.isKeyPressed(Key.VK_W)) hero.setVelocityY(0);
            }
        });

        keyboard.setKeyListener(Key.VK_A, new KeyListener() {
            @Override
            public void onPressed(Keyboard kb) {
                hero.setVelocityX(-speed);
            }

            @Override
            public void onReleased(Keyboard kb) {
                if(!kb.isKeyPressed(Key.VK_D)) hero.setVelocityX(0);
            }
        });

        keyboard.setKeyListener(Key.VK_D, new KeyListener() {
            @Override
            public void onPressed(Keyboard kb) {
                hero.setVelocityX(speed);
            }

            @Override
            public void onReleased(Keyboard kb) {
                if(!kb.isKeyPressed(Key.VK_A)) hero.setVelocityX(0);
            }
        });

        var mouse = Game.get().window().mouse();

        mouse.addListener(MouseButton.LEFT, new ButtonListener() {
            @Override
            public void onPressed(Mouse mouse) {
                hero.setPosition(mouse.x(), mouse.y());
                AudioManager.get().loadRessource("audio/Norwegen.wav")
                        .setStart(5, TimeUnit.SECONDS)
                        .play(Lanes.MUSIC);
            }
        });

        mouse.addListener(MouseButton.RIGHT, new ButtonListener() {
            @Override
            public void onPressed(Mouse mouse) {
                hero.setPosition(mouse.x(), mouse.y());
                AudioManager.get().loadRessource("audio/Saufen.wav")
                        .setStart(10, TimeUnit.SECONDS)
                        .setEnd(15, TimeUnit.SECONDS)
                        .play(Lanes.EFFECT);
            }
        });

        mouse.setMouseWheelListener(System.out::println);
    }

}
