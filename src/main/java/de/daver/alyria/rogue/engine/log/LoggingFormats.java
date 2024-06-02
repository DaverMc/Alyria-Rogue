package de.daver.alyria.rogue.engine.log;

public enum LoggingFormats implements LogFormat {

    PREFIX("[<date>][<time>][<prefix>]"),

    INFO(PREFIX.pattern + ": <message>"),
    DETAILED_INFO(PREFIX.pattern + ": <message> {<parameters>}"),

    EXCEPTION(PREFIX.pattern + " Exception: <stacktrace>"),
    DETAILED_EXCEPTION(PREFIX.pattern + " Exception: <stacktrace> {<parameters>}"),
    EXCEPTION_INFO(PREFIX.pattern + " Exception: <message> \n- Exception: <stacktrace>"),
    DETAILED_EXCEPTION_INFO(PREFIX.pattern + " Exception: <message> {<parameters>} \n- Exception: <stacktrace>");

    private final String pattern;

    LoggingFormats(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String pattern() {
        return this.pattern;
    }
}
