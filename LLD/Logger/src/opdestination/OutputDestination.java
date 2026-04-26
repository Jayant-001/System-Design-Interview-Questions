package opdestination;

import model.LogMessage;

public interface OutputDestination {
    
    boolean write(LogMessage message);

    void stop();
}
