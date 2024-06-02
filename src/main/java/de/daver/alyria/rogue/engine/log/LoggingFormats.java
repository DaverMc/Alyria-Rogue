package de.daver.alyria.rogue.engine.log;

public enum LoggingFormats implements LogFormat {
    INFO("[<time>][<prefix>][<level>]: <message>"),
    DETAILED_INFO("[<time>][<prefix>][<level>]: <message> {<parameters>}"),
    EXCEPTION("[<time>][<prefix>][<level>] Exception: <stacktrace>"),
    DETAILED_EXCEPTION("[<time>][<prefix>][<level>] Exception: <stacktrace> {<parameters>}"),
    EXCEPTION_INFO("[<time>][<prefix>][<level>]: <message> \n-> Exception: <stacktrace>"),
    DETAILED_EXCEPTION_INFO("[<time>][<prefix>][<level>]: <message> {<parameters>} \n-> Exception: <stacktrace>");

    private final String pattern;

    LoggingFormats(String pattern) {
        this.pattern = pattern;
    }


    @Override
    public String pattern() {
        return this.pattern;
    }
}
