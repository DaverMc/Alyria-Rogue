package de.daver.alyria.rogue.engine.log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class LogWriter {

    private final List<LogEntry> pipeline;
    private final List<Level> listeningLevels;

    public LogWriter(Level...levels) {
        this.pipeline = new ArrayList<>();
        this.listeningLevels = new ArrayList<>();
        this.listeningLevels.addAll(Arrays.asList(levels));
    }

    public void addLevel(Level level) {
        listeningLevels.add(level);
    }

    public boolean isListening(Level level) {
        return listeningLevels.contains(level);
    }

    public void addToPipeline(LogEntry entry) {
        pipeline.add(entry);
    }

    abstract void writeLog(LogEntry entry);

}
