package de.daver.alyria.rogue.engine.log;

import java.time.LocalDateTime;
import java.util.Map;

public record LogEntry(Level level, String message, Throwable throwable, Map<String, String> parameters, Thread thread, LocalDateTime time) {

}
