package de.daver.alyria.rogue.gui.io;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Mouse extends MouseAdapter {

    private final boolean[] buttons;
    private final Map<Integer, ButtonListener> listeners;
    private final Map<Integer, Future<?>> tasks;
    private final ScheduledExecutorService scheduler;

    private MouseWheelListener mouseWheelListener;
    private boolean inView;
    private int x;
    private int y;

    public Mouse() {
        this.buttons = new boolean[10];
        this.listeners = new HashMap<>();
        this.tasks = new HashMap<>();
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void setMouseWheelListener(MouseWheelListener mouseWheelListener) {
        this.mouseWheelListener = mouseWheelListener;
    }

    public void addListener(int button, ButtonListener listener) {
        listeners.put(button, listener);
    }

    public void mouseWheelMoved(MouseWheelEvent e){
        if(mouseWheelListener == null) return;
        mouseWheelListener.onMoved(e.getWheelRotation());
    }

    public void mousePressed(MouseEvent e) {
        int keyCode = e.getButton();
        if(buttons[keyCode]) return;
        buttons[keyCode] = true;
        if(listeners.containsKey(keyCode)) {
            ButtonListener listener = listeners.get(keyCode);
            listener.onPressed();
            long delay = listener.holdingDelay();
            if(delay < 0) return;
            if(delay == 0) System.out.println("WARNING: Delay set to 0ms"); //TODO Do important logging
            var future = this.scheduler.scheduleWithFixedDelay(listener::onHold, delay, delay, TimeUnit.MILLISECONDS);
            tasks.put(keyCode, future);
        }
    }

    public void mouseReleased(MouseEvent e) {
        int keyCode = e.getButton();
        buttons[keyCode] = false;
        if (listeners.containsKey(keyCode)) {
            ButtonListener listener = listeners.get(keyCode);
            listener.onReleased();
            var future = this.tasks.remove(keyCode);
            if (future == null) return;
            future.cancel(true);
        }
    }

    public void mouseEntered(MouseEvent e) {
        this.inView = true;
    }

    public void mouseExited(MouseEvent e) {
        this.inView = false;
    }

    public boolean buttonPressed(int button) {
        return this.buttons[button];
    }

    public boolean isInView() {
        return this.inView;
    }
}
