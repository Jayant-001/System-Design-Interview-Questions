package model;

import java.time.LocalDateTime;

public class LogMessage {
    private LocalDateTime timestamp;
    private String className;
    private LogLevel level;
    private String message;

    public LogMessage(LocalDateTime timestamp, String className, LogLevel level, String message) {
        this.timestamp = timestamp;
        this.className = className;
        this.level = level;
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public String getClassName() {
        return this.className;
    }

    public LogLevel getLogLevel() {
        return this.level;
    }

    public String getMessage() {
        return this.message;
    }
}
