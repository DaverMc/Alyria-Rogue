package de.daver.alyria.rogue.engine.log;

public enum LoggingLevels implements Level{
    ERROR(1000, "Error", "ERR"),
    INFO(500, "Info", "INFO"),
    DEBUG(300, "Debug", "DEBUG");

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
