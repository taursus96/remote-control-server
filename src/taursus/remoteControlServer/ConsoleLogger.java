package taursus.remoteControlServer;

import taursus.remoteControl.ILogger;

public class ConsoleLogger implements ILogger {
    protected static class ConsoleLoggerLoader {
        private static final ConsoleLogger INSTANCE = new ConsoleLogger();
    }

    protected ConsoleLogger() {
        if (ConsoleLoggerLoader.INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }
    }

    public static ConsoleLogger getInstance() {
        return ConsoleLoggerLoader.INSTANCE;
    }

    @Override
    public void log(String type, String message) {
        System.out.println(type + ": " + message);
    }

}

