package de.daver.alyria.rogue.engine.gui.input;

import java.awt.event.MouseEvent;

public enum MouseButton {

    LEFT(MouseEvent.BUTTON1, "Left Button"),
    MIDDLE(MouseEvent.BUTTON2, "Middle Button"),
    RIGHT(MouseEvent.BUTTON3, "Right Button");

    private final int code;
    private final String name;

    MouseButton(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public static MouseButton getButton(int code) {
        for (MouseButton button : MouseButton.values()) {
            if (button.getCode() == code)  return button;
        }

        return null;
    }
}
