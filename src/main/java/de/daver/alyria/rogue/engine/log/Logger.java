package de.daver.alyria.rogue.engine.log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Logger {

    private static Logger instance;

    private final ExecutorService threadPool;
    protected final List<LogWriter> logWriters;

    private Logger() {
        this.logWriters = new ArrayList<>();
        this.threadPool = Executors.newVirtualThreadPerTaskExecutor();
    }

    public void addLogWriter(LogWriter logWriter) {
        this.logWriters.add(logWriter);
    }

    protected void log(LogEntry entry) {
        for (LogWriter writer : logWriters)
            if(writer.isListening(entry.level())) this.threadPool.submit(() -> writer.writeLog(entry));
    }

    public static Logger get() {
        if (instance == null) instance = new Logger();
        return instance;
    }

    public static LogRecord record(Level level) {
        return new LogRecord(level);
    }

}
