package model;

import java.util.List;

public class LoggerConfig {
    private final String level;
    private final List<String> destinations;

    public LoggerConfig(String level, List<String> destinations) {
        this.level = level;
        this.destinations = destinations;
    }

    public String getLevel() {
        return this.level;
    }

    public List<String> getOutputDestinations() {
        return this.destinations;
    }
}
