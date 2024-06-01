package de.daver.alyria.rogue.game;

import de.daver.alyria.rogue.gui.Window;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Game {

    // PUBLIC CONSTANTS
    // Gui Constants
    public static final int GUI_WIDTH = 1280;
    public static final int GUI_HEIGHT = 720;

    //Game Constants
    public static final int TICKS_PER_SECOND = 20;

    // PRIVATE CONSTANTS
    private static final int MS_PER_TICK = 1000 / TICKS_PER_SECOND;

    // PRIVATE STATIC VARIABLES
    private static Game instance;

    // PRIVATE ATTRIBUTES
    private final Window window;
    private final Map<UUID, GameObject> objects;

    // PRIVATE VARIABLES
    private long lasTick;
    private boolean running;
    private Stage currentStage;

    private Game() {
        this.window = new Window(GUI_WIDTH, GUI_HEIGHT);
        this.objects = new HashMap<>();
    }

    public boolean start() {
        if(running) return false;
        running = true;
        window.show();
        return true;
    }

    public boolean run() {
        if(System.currentTimeMillis() - lasTick >= MS_PER_TICK) {
            tick();
            lasTick = System.currentTimeMillis();
        }
        render();
        return this.running;
    }

    private void tick() {

    }

    private void render() {
        window.update();
    }

    public void stop() {
        running = false;
    }

    public void save() {

    }

    public Window window() {
        return this.window;
    }

    public void addObject(GameObject object) {
        this.objects.put(object.uuid(), object);
    }

    public static Game get() {
        if(instance == null) instance = new Game();
        return instance;
    }

}
