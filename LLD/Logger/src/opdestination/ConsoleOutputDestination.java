package opdestination;

import formatter.LogFormatter;
import model.LogMessage;

public class ConsoleOutputDestination implements OutputDestination {

    private final LogFormatter formatter;

    public ConsoleOutputDestination(LogFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public boolean write(LogMessage message) {
        String msg = formatter.format(message);
        System.out.println(msg);
        return true;
    }

    public void stop() {
        
    }
}
