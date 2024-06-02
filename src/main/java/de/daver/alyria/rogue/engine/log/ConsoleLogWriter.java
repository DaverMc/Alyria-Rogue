package de.daver.alyria.rogue.engine.log;

import java.io.PrintStream;

public abstract class ConsoleLogWriter extends LogWriter{

    private final PrintStream out;
    private final PrintStream err;

    private LogFormatter infoFormatter;
    private LogFormatter errMsgFormatter;
    private LogFormatter exceptionFormatter;
    private LogFormatter errMssExceptionFormatter;

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

        this.infoFormatter = new LogFormatter(LoggingFormats.INFO);
        this.errMsgFormatter = new LogFormatter(LoggingFormats.INFO);

        this.exceptionFormatter = new LogFormatter(LoggingFormats.EXCEPTION);
        exceptionFormatter.setStacktraceDepth(1);

        this.errMssExceptionFormatter = new LogFormatter(LoggingFormats.EXCEPTION_INFO);
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
        return infoFormatter.format(entry);
    }

    protected String formatErrorMsg(LogEntry entry) {
        LogFormatter formatter = null;

        if(entry.throwable() != null && entry.message() != null) formatter = errMssExceptionFormatter;
        else if(entry.throwable() != null) formatter = exceptionFormatter;
        else if(entry.message() != null) formatter = errMsgFormatter;

        return (formatter == null)? "" : formatter.format(entry);
    }

}
