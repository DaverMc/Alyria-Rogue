package de.daver.alyria.rogue.engine.log;

import java.time.format.DateTimeFormatter;
import java.util.Map;

public class LogFormatter {



    private final String pattern;
    private int stacktraceDepth;
    private String dateFormat;

    public LogFormatter(LogFormat pattern) {
        this(pattern.pattern());
    }

    private LogFormatter(String pattern) {
        this.pattern = pattern;
        this.stacktraceDepth = -1;
        this.dateFormat = "hh:mm:ss";
    }

    public void setStacktraceDepth(int depth) {
        this.stacktraceDepth = depth;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String format(LogEntry entry) {
        String message = pattern;
        message = replaceKey(message, LogFormat.KEY_TIME, entry.time().format(DateTimeFormatter.ofPattern(dateFormat)));
        message = replaceKey(message, LogFormat.KEY_PREFIX, entry.level().getPrefix());
        message = replaceKey(message, LogFormat.KEY_LEVEL, entry.level().getName());
        message = replaceKey(message, LogFormat.KEY_MESSAGE, entry.message());
        message = replaceKey(message, LogFormat.KEY_STACKTRACE, printStacktrace(entry.throwable()));
        message = replaceKey(message, LogFormat.KEY_THREAD, entry.thread().getName());
        message = replaceKey(message, LogFormat.KEY_PARAMETERS, printParameters(entry.parameters()));

        for(String key : entry.parameters().keySet()) message = replaceKey(message, "<par_" + key + ">", entry.parameters().get(key));

        return message;
    }

    private String replaceKey(String raw, String key, Object value) {
        return raw.replaceAll(key, (value == null)? "null" : String.valueOf(value));
    }

    private String printStacktrace(Throwable throwable) {
        if (throwable == null) return "null";
        StringBuilder msg = new StringBuilder(throwable.getMessage() + "\n");
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        int displayLimit = (stacktraceDepth == -1) ? stackTrace.length : Math.min(stacktraceDepth, stackTrace.length);
        for (int i = 0; i < displayLimit; i++) {
            msg.append("\tat ").append(stackTrace[i].toString()).append("\n");
        }
        if (displayLimit < stackTrace.length) {
            msg.append("\t... and ").append(stackTrace.length - displayLimit).append(" more line");
            if(displayLimit - stackTrace.length > 1) msg.append("s");
        }
        return msg.toString();
    }

    private String printParameters(Map<String, String> parameters) {
        StringBuilder msg = new StringBuilder();
        parameters.forEach((key, value) -> {
            msg.append(key).append("=").append(value).append(",");
        });
        if (!msg.isEmpty()) {
            msg.setLength(msg.length() - 1); // Remove the last comma
        }
        return msg.toString();
    }
}
