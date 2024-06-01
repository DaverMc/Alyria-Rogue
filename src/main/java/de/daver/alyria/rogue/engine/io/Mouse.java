package de.daver.alyria.rogue.engine.io;

import de.daver.alyria.rogue.engine.game.Game;

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
        updatePosition(e);
        if(buttons[keyCode]) return;
        buttons[keyCode] = true;
        if(listeners.containsKey(keyCode)) {
            ButtonListener listener = listeners.get(keyCode);
            listener.onPressed(this);
            long delay = listener.holdingDelay();
            if(delay < 0) return;
            if(delay == 0) System.out.println("WARNING: Delay set to 0ms"); //TODO Do important logging
            var future = this.scheduler.scheduleWithFixedDelay(() -> listener.onHold(this), delay, delay, TimeUnit.MILLISECONDS);
            tasks.put(keyCode, future);
        }
    }

    public void mouseReleased(MouseEvent e) {
        int keyCode = e.getButton();
        updatePosition(e);
        buttons[keyCode] = false;
        if (listeners.containsKey(keyCode)) {
            ButtonListener listener = listeners.get(keyCode);
            listener.onReleased(this);
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

    public boolean isButtonPressed(int button) {
        return this.buttons[button];
    }

    public boolean isInView() {
        return this.inView;
    }

    private void updatePosition(MouseEvent e) {
        float scaleX = (float) Game.GUI_WIDTH / Game.get().window().width();
        float scaleY = (float) Game.GUI_HEIGHT / Game.get().window().height();
        this.x = (int) (e.getX() * scaleX);
        this.y = (int) (e.getY() * scaleY);
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }
}
