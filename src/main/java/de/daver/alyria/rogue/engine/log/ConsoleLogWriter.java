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
        var formatter = new LogFormatter("[<time>][<prefix>][<level>]: <message> (<par_count>) {<parameters>}");
        return formatter.format(entry);
    }

    protected String formatErrorMsg(LogEntry entry) {
        LogFormatter formatter = null;

        if(entry.throwable() != null && entry.message() != null) formatter = new LogFormatter("[<time>][<prefix>][<level>]: <message> \n-> Exception: <stacktrace>");
        else if(entry.throwable() != null) formatter = new LogFormatter("[<time>][<prefix>][<level>] Exception: <stacktrace>");
        else if(entry.message() != null) formatter = new LogFormatter("[<time>][<prefix>][<level>]: <message>");

        formatter.setStacktraceDepth(1);

        return (formatter == null)? "" : formatter.format(entry);
    }

}
