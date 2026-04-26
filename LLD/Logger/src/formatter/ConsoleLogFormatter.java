package formatter;

import model.LogMessage;

public class ConsoleLogFormatter implements LogFormatter {

    @Override
    public String format(LogMessage message) {
        
        String stringMessage = String.format("%s [%s] %s %s", 
            message.getTimestamp(),
            message.getClassName(),
            message.getLogLevel(),
            message.getMessage()
        );
        return stringMessage;
    }
    
}
