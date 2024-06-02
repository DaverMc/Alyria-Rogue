package de.daver.alyria.rogue.engine.log;

public interface LogFormat {

    String KEY_TIME = "<time>";
    String KEY_DATE = "<date>";
    String KEY_PREFIX = "<prefix>";
    String KEY_LEVEL = "<level>";
    String KEY_MESSAGE = "<message>";
    String KEY_STACKTRACE = "<stacktrace>";
    String KEY_THREAD = "<thread>";
    String KEY_PARAMETERS = "<parameters>";

    String pattern();

}
