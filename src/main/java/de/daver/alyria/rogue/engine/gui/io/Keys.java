package de.daver.alyria.rogue.engine.gui.io;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public enum Keys {

    VK_ENTER(KeyEvent.VK_ENTER, "Enter"),
    VK_BACK_SPACE(KeyEvent.VK_BACK_SPACE, "Back Space"),
    VK_TAB(KeyEvent.VK_TAB, "Tab"),
    VK_CANCEL(KeyEvent.VK_CANCEL, "Cancel"),
    VK_CLEAR(KeyEvent.VK_CLEAR, "Clear"),
    VK_SHIFT(KeyEvent.VK_SHIFT, "Shift"),
    VK_CONTROL(KeyEvent.VK_CONTROL, "Control"),
    VK_ALT(KeyEvent.VK_ALT, "Alt"),
    VK_PAUSE(KeyEvent.VK_PAUSE, "Pause"),
    VK_CAPS_LOCK(KeyEvent.VK_CAPS_LOCK, "Caps Lock"),
    VK_ESCAPE(KeyEvent.VK_ESCAPE, "Escape"),
    VK_SPACE(KeyEvent.VK_SPACE, "Space"),
    VK_PAGE_UP(KeyEvent.VK_PAGE_UP, "Page Up"),
    VK_PAGE_DOWN(KeyEvent.VK_PAGE_DOWN, "Page Down"),
    VK_END(KeyEvent.VK_END, "End"),
    VK_HOME(KeyEvent.VK_HOME, "Home"),
    VK_LEFT(KeyEvent.VK_LEFT, "Left"),
    VK_UP(KeyEvent.VK_UP, "Up"),
    VK_RIGHT(KeyEvent.VK_RIGHT, "Right"),
    VK_DOWN(KeyEvent.VK_DOWN, "Down"),
    VK_COMMA(KeyEvent.VK_COMMA, "Comma"),
    VK_MINUS(KeyEvent.VK_MINUS, "Minus"),
    VK_PERIOD(KeyEvent.VK_PERIOD, "Period"),
    VK_SLASH(KeyEvent.VK_SLASH, "Slash"),
    VK_0(KeyEvent.VK_0, "0"),
    VK_1(KeyEvent.VK_1, "1"),
    VK_2(KeyEvent.VK_2, "2"),
    VK_3(KeyEvent.VK_3, "3"),
    VK_4(KeyEvent.VK_4, "4"),
    VK_5(KeyEvent.VK_5, "5"),
    VK_6(KeyEvent.VK_6, "6"),
    VK_7(KeyEvent.VK_7, "7"),
    VK_8(KeyEvent.VK_8, "8"),
    VK_9(KeyEvent.VK_9, "9"),
    VK_SEMICOLON(KeyEvent.VK_SEMICOLON, "Semicolon"),
    VK_EQUALS(KeyEvent.VK_EQUALS, "Equals"),
    VK_A(KeyEvent.VK_A, "A"),
    VK_B(KeyEvent.VK_B, "B"),
    VK_C(KeyEvent.VK_C, "C"),
    VK_D(KeyEvent.VK_D, "D"),
    VK_E(KeyEvent.VK_E, "E"),
    VK_F(KeyEvent.VK_F, "F"),
    VK_G(KeyEvent.VK_G, "G"),
    VK_H(KeyEvent.VK_H, "H"),
    VK_I(KeyEvent.VK_I, "I"),
    VK_J(KeyEvent.VK_J, "J"),
    VK_K(KeyEvent.VK_K, "K"),
    VK_L(KeyEvent.VK_L, "L"),
    VK_M(KeyEvent.VK_M, "M"),
    VK_N(KeyEvent.VK_N, "N"),
    VK_O(KeyEvent.VK_O, "O"),
    VK_P(KeyEvent.VK_P, "P"),
    VK_Q(KeyEvent.VK_Q, "Q"),
    VK_R(KeyEvent.VK_R, "R"),
    VK_S(KeyEvent.VK_S, "S"),
    VK_T(KeyEvent.VK_T, "T"),
    VK_U(KeyEvent.VK_U, "U"),
    VK_V(KeyEvent.VK_V, "V"),
    VK_W(KeyEvent.VK_W, "W"),
    VK_X(KeyEvent.VK_X, "X"),
    VK_Y(KeyEvent.VK_Y, "Y"),
    VK_Z(KeyEvent.VK_Z, "Z"),
    VK_OPEN_BRACKET(KeyEvent.VK_OPEN_BRACKET, "Open Bracket"),
    VK_BACK_SLASH(KeyEvent.VK_BACK_SLASH, "Back Slash"),
    VK_CLOSE_BRACKET(KeyEvent.VK_CLOSE_BRACKET, "Close Bracket"),
    VK_NUMPAD0(KeyEvent.VK_NUMPAD0, "Numpad 0"),
    VK_NUMPAD1(KeyEvent.VK_NUMPAD1, "Numpad 1"),
    VK_NUMPAD2(KeyEvent.VK_NUMPAD2, "Numpad 2"),
    VK_NUMPAD3(KeyEvent.VK_NUMPAD3, "Numpad 3"),
    VK_NUMPAD4(KeyEvent.VK_NUMPAD4, "Numpad 4"),
    VK_NUMPAD5(KeyEvent.VK_NUMPAD5, "Numpad 5"),
    VK_NUMPAD6(KeyEvent.VK_NUMPAD6, "Numpad 6"),
    VK_NUMPAD7(KeyEvent.VK_NUMPAD7, "Numpad 7"),
    VK_NUMPAD8(KeyEvent.VK_NUMPAD8, "Numpad 8"),
    VK_NUMPAD9(KeyEvent.VK_NUMPAD9, "Numpad 9"),
    VK_MULTIPLY(KeyEvent.VK_MULTIPLY, "Multiply"),
    VK_ADD(KeyEvent.VK_ADD, "Add"),
    VK_SEPARATOR(KeyEvent.VK_SEPARATOR, "Separator"),
    VK_SUBTRACT(KeyEvent.VK_SUBTRACT, "Subtract"),
    VK_DECIMAL(KeyEvent.VK_DECIMAL, "Decimal"),
    VK_DIVIDE(KeyEvent.VK_DIVIDE, "Divide"),
    VK_DELETE(KeyEvent.VK_DELETE, "Delete"),
    VK_NUM_LOCK(KeyEvent.VK_NUM_LOCK, "Num Lock"),
    VK_SCROLL_LOCK(KeyEvent.VK_SCROLL_LOCK, "Scroll Lock"),
    VK_F1(KeyEvent.VK_F1, "F1"),
    VK_F2(KeyEvent.VK_F2, "F2"),
    VK_F3(KeyEvent.VK_F3, "F3"),
    VK_F4(KeyEvent.VK_F4, "F4"),
    VK_F5(KeyEvent.VK_F5, "F5"),
    VK_F6(KeyEvent.VK_F6, "F6"),
    VK_F7(KeyEvent.VK_F7, "F7"),
    VK_F8(KeyEvent.VK_F8, "F8"),
    VK_F9(KeyEvent.VK_F9, "F9"),
    VK_F10(KeyEvent.VK_F10, "F10"),
    VK_F11(KeyEvent.VK_F11, "F11"),
    VK_F12(KeyEvent.VK_F12, "F12"),
    VK_F13(KeyEvent.VK_F13, "F13"),
    VK_F14(KeyEvent.VK_F14, "F14"),
    VK_F15(KeyEvent.VK_F15, "F15"),
    VK_F16(KeyEvent.VK_F16, "F16"),
    VK_F17(KeyEvent.VK_F17, "F17"),
    VK_F18(KeyEvent.VK_F18, "F18"),
    VK_F19(KeyEvent.VK_F19, "F19"),
    VK_F20(KeyEvent.VK_F20, "F20"),
    VK_F21(KeyEvent.VK_F21, "F21"),
    VK_F22(KeyEvent.VK_F22, "F22"),
    VK_F23(KeyEvent.VK_F23, "F23"),
    VK_F24(KeyEvent.VK_F24, "F24"),
    VK_PRINTSCREEN(KeyEvent.VK_PRINTSCREEN, "Print Screen"),
    VK_INSERT(KeyEvent.VK_INSERT, "Insert"),
    VK_HELP(KeyEvent.VK_HELP, "Help"),
    VK_META(KeyEvent.VK_META, "Meta"),
    VK_BACK_QUOTE(KeyEvent.VK_BACK_QUOTE, "Back Quote"),
    VK_QUOTE(KeyEvent.VK_QUOTE, "Quote"),
    VK_KP_UP(KeyEvent.VK_KP_UP, "Keypad Up"),
    VK_KP_DOWN(KeyEvent.VK_KP_DOWN, "Keypad Down"),
    VK_KP_LEFT(KeyEvent.VK_KP_LEFT, "Keypad Left"),
    VK_KP_RIGHT(KeyEvent.VK_KP_RIGHT, "Keypad Right"),
    VK_DEAD_GRAVE(KeyEvent.VK_DEAD_GRAVE, "Dead Grave"),
    VK_DEAD_ACUTE(KeyEvent.VK_DEAD_ACUTE, "Dead Acute"),
    VK_DEAD_CIRCUMFLEX(KeyEvent.VK_DEAD_CIRCUMFLEX, "Dead Circumflex"),
    VK_DEAD_TILDE(KeyEvent.VK_DEAD_TILDE, "Dead Tilde"),
    VK_DEAD_MACRON(KeyEvent.VK_DEAD_MACRON, "Dead Macron"),
    VK_DEAD_BREVE(KeyEvent.VK_DEAD_BREVE, "Dead Breve"),
    VK_DEAD_ABOVEDOT(KeyEvent.VK_DEAD_ABOVEDOT, "Dead Above Dot"),
    VK_DEAD_DIAERESIS(KeyEvent.VK_DEAD_DIAERESIS, "Dead Diaeresis"),
    VK_DEAD_ABOVERING(KeyEvent.VK_DEAD_ABOVERING, "Dead Above Ring"),
    VK_DEAD_DOUBLEACUTE(KeyEvent.VK_DEAD_DOUBLEACUTE, "Dead Double Acute"),
    VK_DEAD_CARON(KeyEvent.VK_DEAD_CARON, "Dead Caron"),
    VK_DEAD_CEDILLA(KeyEvent.VK_DEAD_CEDILLA, "Dead Cedilla"),
    VK_DEAD_OGONEK(KeyEvent.VK_DEAD_OGONEK, "Dead Ogonek"),
    VK_DEAD_IOTA(KeyEvent.VK_DEAD_IOTA, "Dead Iota"),
    VK_DEAD_VOICED_SOUND(KeyEvent.VK_DEAD_VOICED_SOUND, "Dead Voiced Sound"),
    VK_DEAD_SEMIVOICED_SOUND(KeyEvent.VK_DEAD_SEMIVOICED_SOUND, "Dead Semivoiced Sound"),
    VK_AMPERSAND(KeyEvent.VK_AMPERSAND, "Ampersand"),
    VK_ASTERISK(KeyEvent.VK_ASTERISK, "Asterisk"),
    VK_QUOTEDBL(KeyEvent.VK_QUOTEDBL, "Double Quote"),
    VK_LESS(KeyEvent.VK_LESS, "Less Than"),
    VK_GREATER(KeyEvent.VK_GREATER, "Greater Than"),
    VK_BRACELEFT(KeyEvent.VK_BRACELEFT, "Left Brace"),
    VK_BRACERIGHT(KeyEvent.VK_BRACERIGHT, "Right Brace"),
    VK_AT(KeyEvent.VK_AT, "At"),
    VK_COLON(KeyEvent.VK_COLON, "Colon"),
    VK_CIRCUMFLEX(KeyEvent.VK_CIRCUMFLEX, "Circumflex"),
    VK_DOLLAR(KeyEvent.VK_DOLLAR, "Dollar"),
    VK_EURO_SIGN(KeyEvent.VK_EURO_SIGN, "Euro Sign"),
    VK_EXCLAMATION_MARK(KeyEvent.VK_EXCLAMATION_MARK, "Exclamation Mark"),
    VK_INVERTED_EXCLAMATION_MARK(KeyEvent.VK_INVERTED_EXCLAMATION_MARK, "Inverted Exclamation Mark"),
    VK_LEFT_PARENTHESIS(KeyEvent.VK_LEFT_PARENTHESIS, "Left Parenthesis"),
    VK_NUMBER_SIGN(KeyEvent.VK_NUMBER_SIGN, "Number Sign"),
    VK_PLUS(KeyEvent.VK_PLUS, "Plus"),
    VK_RIGHT_PARENTHESIS(KeyEvent.VK_RIGHT_PARENTHESIS, "Right Parenthesis"),
    VK_UNDERSCORE(KeyEvent.VK_UNDERSCORE, "Underscore"),
    VK_WINDOWS(KeyEvent.VK_WINDOWS, "Windows"),
    VK_CONTEXT_MENU(KeyEvent.VK_CONTEXT_MENU, "Context Menu"),
    VK_FINAL(KeyEvent.VK_FINAL, "Final"),
    VK_CONVERT(KeyEvent.VK_CONVERT, "Convert"),
    VK_NONCONVERT(KeyEvent.VK_NONCONVERT, "Nonconvert"),
    VK_ACCEPT(KeyEvent.VK_ACCEPT, "Accept"),
    VK_MODECHANGE(KeyEvent.VK_MODECHANGE, "Mode Change"),
    VK_KANA(KeyEvent.VK_KANA, "Kana"),
    VK_KANJI(KeyEvent.VK_KANJI, "Kanji"),
    VK_ALPHANUMERIC(KeyEvent.VK_ALPHANUMERIC, "Alphanumeric"),
    VK_KATAKANA(KeyEvent.VK_KATAKANA, "Katakana"),
    VK_HIRAGANA(KeyEvent.VK_HIRAGANA, "Hiragana"),
    VK_FULL_WIDTH(KeyEvent.VK_FULL_WIDTH, "Full Width"),
    VK_HALF_WIDTH(KeyEvent.VK_HALF_WIDTH, "Half Width"),
    VK_ROMAN_CHARACTERS(KeyEvent.VK_ROMAN_CHARACTERS, "Roman Characters"),
    VK_ALL_CANDIDATES(KeyEvent.VK_ALL_CANDIDATES, "All Candidates"),
    VK_PREVIOUS_CANDIDATE(KeyEvent.VK_PREVIOUS_CANDIDATE, "Previous Candidate"),
    VK_CODE_INPUT(KeyEvent.VK_CODE_INPUT, "Code Input"),
    VK_JAPANESE_KATAKANA(KeyEvent.VK_JAPANESE_KATAKANA, "Japanese Katakana"),
    VK_JAPANESE_HIRAGANA(KeyEvent.VK_JAPANESE_HIRAGANA, "Japanese Hiragana"),
    VK_JAPANESE_ROMAN(KeyEvent.VK_JAPANESE_ROMAN, "Japanese Roman"),
    VK_KANA_LOCK(KeyEvent.VK_KANA_LOCK, "Kana Lock"),
    VK_INPUT_METHOD_ON_OFF(KeyEvent.VK_INPUT_METHOD_ON_OFF, "Input Method On/Off"),
    VK_CUT(KeyEvent.VK_CUT, "Cut"),
    VK_COPY(KeyEvent.VK_COPY, "Copy"),
    VK_PASTE(KeyEvent.VK_PASTE, "Paste"),
    VK_UNDO(KeyEvent.VK_UNDO, "Undo"),
    VK_AGAIN(KeyEvent.VK_AGAIN, "Again"),
    VK_FIND(KeyEvent.VK_FIND, "Find"),
    VK_PROPS(KeyEvent.VK_PROPS, "Properties"),
    VK_STOP(KeyEvent.VK_STOP, "Stop"),
    VK_COMPOSE(KeyEvent.VK_COMPOSE, "Compose"),
    VK_ALT_GRAPH(KeyEvent.VK_ALT_GRAPH, "Alt Graph"),
    VK_BEGIN(KeyEvent.VK_BEGIN, "Begin"),
    VK_UNDEFINED(KeyEvent.VK_UNDEFINED, "Undefined");

    private static final Map<Integer, Keys> MAP = new HashMap<>();
    private final int code;
    private final String name;

    static {
        for (Keys value : Keys.values()) {
            MAP.put(value.getCode(), value);
        }
    }

    Keys(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Keys get(int code) {
        return MAP.get(code);
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

}
