
import java.util.List;

import logger.Logger;
import logger.LoggerFactory;
import logger.LoggerManager;
import model.LoggerConfig;

public class App {

    public static void main(String[] args) throws Exception {

        LoggerConfig config = new LoggerConfig("INFO", List.of("CONSOLE", "TXT_FILE"));

        LoggerManager manager = LoggerFactory.createLoggerManager(config);
        Logger log = manager.getLogger(App.class);

        log.debug("Hello, World!");
        log.info("Hello, World!");
        log.warn("Hello, World!");
        log.error("Hello, World!");
        log.fatal("Hello, World!");

        log.shutdown();

        log.info("hello debug");
    }
}
