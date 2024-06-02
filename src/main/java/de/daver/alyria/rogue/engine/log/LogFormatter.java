package de.daver.alyria.rogue.engine.log;

import java.time.format.DateTimeFormatter;
import java.util.Map;

public class LogFormatter {

    public static final String KEY_TIME = "<time>";
    public static final String KEY_PREFIX = "<prefix>";
    public static final String KEY_LEVEL = "<level>";
    public static final String KEY_MESSAGE = "<message>";
    public static final String KEY_STACKTRACE = "<stacktrace>";
    public static final String KEY_THREAD = "<thread>";
    public static final String KEY_PARAMETERS = "<parameters>";

    private final String format;
    private int stacktraceDepth;
    private String dateFormat;

    public LogFormatter(String format) {
        this.format = format;
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
        String message = format;
        message = replaceKey(message, KEY_TIME, entry.time().format(DateTimeFormatter.ofPattern(dateFormat)));
        message = replaceKey(message, KEY_PREFIX, entry.level().getPrefix());
        message = replaceKey(message, KEY_LEVEL, entry.level().getName());
        message = replaceKey(message, KEY_MESSAGE, entry.message());
        message = replaceKey(message, KEY_STACKTRACE, printStacktrace(entry.throwable()));
        message = replaceKey(message, KEY_THREAD, entry.thread().getName());
        message = replaceKey(message, KEY_PARAMETERS, printParameters(entry.parameters()));

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
