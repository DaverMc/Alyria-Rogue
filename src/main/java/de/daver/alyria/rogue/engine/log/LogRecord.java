package de.daver.alyria.rogue.engine.log;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class LogRecord {

    private final Level level;
    private final Map<String, String> parameters;

    private String message;
    private Throwable throwable;
    private Thread thread;
    private LocalDateTime time;

    protected LogRecord(Level level) {
        this.level = level;
        this.parameters = new HashMap<>();
        this.thread = Thread.currentThread();
        this.time = LocalDateTime.now();
    }

    public LogRecord message(String message) {
        this.message = message;
        return this;
    }

    public LogRecord parameter(String key, Object value) {
        this.parameters.put(key, String.valueOf(value));
        return this;
    }

    public LogRecord throwable(Throwable throwable) {
        this.throwable = throwable;
        return this;
    }

    public LogRecord thread(Thread thread) {
        this.thread = thread;
        return this;
    }

    public LogRecord time(LocalDateTime time) {
        this.time = time;
        return this;
    }

    public void log() {
        Logger.get().log(new LogEntry(level, message, throwable, parameters, thread, time));
    }

}
