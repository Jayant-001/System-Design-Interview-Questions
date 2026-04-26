package logger;

import java.time.LocalDateTime;
import java.util.List;

import model.LogLevel;
import model.LogMessage;
import opdestination.OutputDestination;

public class Logger {

    private final List<OutputDestination> destinations;
    private final Class<?> source;
    private final LogLevel level;

    public Logger(List<OutputDestination> destinations, Class<?> source, LogLevel level) {
        this.destinations = destinations;
        this.source = source;
        this.level = level;
    }

    private void log(LogLevel level, String message) {
        if(level.getLevel() < this.level.getLevel()) return;

        LogMessage msg = new LogMessage(LocalDateTime.now(), source.getName(), level, message);
        destinations.forEach(d -> d.write(msg));
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
    
    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }

    public void shutdown() {
        destinations.forEach(d -> d.stop());
    }
}
