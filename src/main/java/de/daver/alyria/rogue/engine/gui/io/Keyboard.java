package de.daver.alyria.rogue.engine.gui.io;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Keyboard implements java.awt.event.KeyListener {

    private final boolean[] keys;
    private final Map<Integer, KeyListener> listeners;
    private final ScheduledExecutorService scheduler;
    private final Map<Integer, Future<?>> tasks;

    public Keyboard() {
        this.keys = new boolean[256];
        this.listeners = new HashMap<>();
        this.tasks = new HashMap<>();
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void setKeyListener(int keyCode, KeyListener keyListener) {
        this.listeners.put(keyCode, keyListener);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keys[keyCode]) return;
        keys[keyCode] = true;
        if(listeners.containsKey(keyCode)) {
            KeyListener listener = listeners.get(keyCode);
            listener.onPressed(this);
            long delay = listener.holdingDelay();
            if(delay < 0) return;
            if(delay == 0) System.out.println("WARNING: Delay set to 0ms"); //TODO Do important logging
            var future = this.scheduler.scheduleWithFixedDelay(() -> listener.onHold(this), delay, delay, TimeUnit.MILLISECONDS);
            tasks.put(keyCode, future);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        keys[keyCode] = false;
        if(listeners.containsKey(keyCode)) {
            KeyListener listener = listeners.get(keyCode);
            listener.onReleased(this);
            var future = this.tasks.remove(keyCode);
            if(future == null) return;
            future.cancel(true);
        }
    }
}
