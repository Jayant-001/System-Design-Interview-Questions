package logger;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import model.LogLevel;
import opdestination.OutputDestination;

public class LoggerManager {
    
    private final List<OutputDestination> destinations;
    private final LogLevel level;
    private final Map<Class<?>, Logger> loggers;

    public LoggerManager(List<OutputDestination> destinations, LogLevel level) {
        this.destinations = destinations;
        this.level = level;
        loggers = new ConcurrentHashMap<>();
    }

    public Logger getLogger(Class<?> source) {
        return loggers.computeIfAbsent(source, 
            cls -> new Logger(this.destinations, source, level)
        );
    }
}
