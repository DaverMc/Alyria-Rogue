package de.daver.alyria.rogue.engine.log;

import java.io.PrintStream;

public abstract class ConsoleLogWriter extends LogWriter{

    private final PrintStream out;
    private final PrintStream err;

    private int errorLevel;

    public ConsoleLogWriter(Level... levels) {
        this(System.out, System.err, levels);
    }

    public ConsoleLogWriter(PrintStream console, Level... levels) {
        this(console, console, levels);
    }

    public ConsoleLogWriter(PrintStream out, PrintStream err, Level... levels) {
        super(levels);
        this.out = out;
        this.err = err;
        this.errorLevel = -1;
    }

    public void setErrorLevel(Level errorLevel) {
        this.errorLevel = errorLevel.getWeight();
    }

    @Override
    void writeLog(LogEntry entry) {
        if(entry.level().getWeight() < errorLevel || errorLevel == -1) out.println(formatMsg(entry));
        else err.println(formatErrorMsg(entry));
    }

    protected String formatMsg(LogEntry entry) {
        return new LogMessageBuilder(entry).time("hh:mm:ss")
                .prefix().separator()
                .logMessage().build();
    }

    protected String formatErrorMsg(LogEntry entry) {
        var message = new LogMessageBuilder(entry);

        if(entry.throwable() != null && entry.message() != null) {
            return message.time("hh:mm:ss")
                    .prefix().separator()
                    .logMessage().newLine()
                    .printStacktrace().build();

        }

        if(entry.throwable() != null) {
            return message.time("hh:mm:ss")
                    .prefix().separator()
                    .printStacktrace().build();
        }

        if(entry.message() != null) {
            return message.time("hh:mm:ss")
                    .prefix().separator()
                    .logMessage().build();
        }

        return "";
    }

}
