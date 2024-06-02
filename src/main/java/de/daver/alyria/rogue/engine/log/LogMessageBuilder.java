package de.daver.alyria.rogue.engine.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LogMessageBuilder {

    private final LogEntry entry;
    private String msg;

    public LogMessageBuilder(LogEntry entry) {
        this.entry = entry;
        this.msg = "";
    }

    public LogMessageBuilder logMessage() {
        String message = entry.message();
        if (message == null) {
            msg += null;
            return this;
        }

        msg += message;
        return this;
    }

    public LogMessageBuilder prefix() {
        String prefix = entry.level().getPrefix();
        if (prefix == null) {
            msg += "null";
            return this;
        }
        msg += "[" + prefix + "]";
        return this;
    }

    public LogMessageBuilder time(String pattern) {
        LocalDateTime time = entry.time();
        if (time == null) {
            msg += "null";
            return this;
        }
        msg += "[" + time.format(DateTimeFormatter.ofPattern(pattern)) + "]";
        return this;
    }

    public LogMessageBuilder printStacktrace() {
        Throwable throwable = entry.throwable();
        if (throwable == null) {
            this.msg += "null";
            return this;
        }
        StringBuilder msg = new StringBuilder("Exception: " + throwable.getMessage() + "\n");
        for (StackTraceElement element : throwable.getStackTrace()) {
            msg.append("\tat ").append(element.toString()).append("\n");
        }
        this.msg += msg.toString();
        return this;
    }

    public LogMessageBuilder newLine() {
        msg += "\n";
        return this;
    }

    public LogMessageBuilder separator() {
        msg += ": ";
        return this;
    }

    public String build() {
        return msg;
    }

}
