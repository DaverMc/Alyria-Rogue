package de.daver.alyria.rogue.engine.log;

public enum LoggingLevels implements Level{

    ERROR(1000, "Error", "ERR"),
    WARNING(700, "Warning", "WARN"),
    CONFIG(500, "Config", "CFG"),
    INFO(500, "Info", "INF"),
    DEBUG(300, "Debug", "DBG"),
    DETAIL(200, "Detail", "DET"),
    DATA(100, "Data", "DAT");

    private final int weight;
    private final String name;
    private final String prefix;

    LoggingLevels(final int weight, final String name, final String prefix) {
        this.weight = weight;
        this.name = name;
        this.prefix = prefix;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public String getPrefix() {
        return this.prefix;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
