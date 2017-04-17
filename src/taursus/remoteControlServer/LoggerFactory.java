package taursus.remoteControlServer;

import com.remoteControl.ILogger;

public class LoggerFactory {

    public static ILogger create() {
        return ConsoleLogger.getInstance();
    }
}
