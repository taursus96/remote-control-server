package taursus.remoteControlServer;

import taursus.remoteControl.ILogger;

public class LoggerFactory {

    public static ILogger create() {
        return ConsoleLogger.getInstance();
    }
}
