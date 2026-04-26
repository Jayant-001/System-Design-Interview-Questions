package logger;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import formatter.ConsoleLogFormatter;
import model.LogLevel;
import model.LoggerConfig;
import opdestination.ConsoleOutputDestination;
import opdestination.FileOutputDestination;
import opdestination.OutputDestination;

public class LoggerFactory {
    
    public static LoggerManager createLoggerManager(LoggerConfig config) {

        LogLevel logLevel = LogLevel.valueOf(config.getLevel());
        List<OutputDestination> destinations = new CopyOnWriteArrayList<>();

        for (String destType : config.getOutputDestinations()) {
            if(destType.equals("CONSOLE")) {
                destinations.add(new ConsoleOutputDestination(new ConsoleLogFormatter()));
            }
            else if(destType.equals("TXT_FILE")) {
                destinations.add(new FileOutputDestination(new ConsoleLogFormatter()));
            }
            else {
                System.out.println("Invalie output destination type " + destType);
            }
        }

        return new LoggerManager(destinations, logLevel);
    }
}
