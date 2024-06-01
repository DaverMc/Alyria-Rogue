package de.daver.alyria.rogue.engine.gui.io;

import java.awt.event.MouseEvent;

public enum Buttons {

    LEFT(MouseEvent.BUTTON1, "Left Button"),
    MIDDLE(MouseEvent.BUTTON2, "Middle Button"),
    RIGHT(MouseEvent.BUTTON3, "Right Button");

    private final int code;
    private final String name;

    Buttons(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public static Buttons getButton(int code) {
        for (Buttons button : Buttons.values()) {
            if (button.getCode() == code)  return button;
        }

        return null;
    }
}
