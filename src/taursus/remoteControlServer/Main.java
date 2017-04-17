package taursus.remoteControlServer;

import java.util.Scanner;
import java.awt.AWTException;
import java.awt.Robot;
import taursus.remoteControl.*;

public class Main {
    public static void main(String[] args) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            return;
        }

        Server server = new Server(LoggerFactory.create());
        IMouseMovementStrategy mouseMovementStrategy = MouseMovementStrategyFactory.create(robot);

        IMouseControl mouseControl = new MouseControl(robot, mouseMovementStrategy, LoggerFactory.create());
        IKeyboardControl keyboardControl = new KeyboardControl(robot, LoggerFactory.create());
        IOptionsControl optionsControl = OptionsControlFactory.create(robot);

        IEventDataSerializer serializer = EventDataSerializer.getInstance();
        MouseEventsListener mouseController = new MouseEventsListener(server, serializer, mouseControl);
        KeyboardEventsListener keyboardController = new KeyboardEventsListener(server, serializer, keyboardControl);
        OptionsEventsExecutor optionsController = new OptionsEventsExecutor(server, serializer, optionsControl);

        server.init();

        Scanner s = new Scanner(System.in);
        while (s.nextLine().compareTo("q") != 0) {
            // input q to exit the program
        }

        server.close();
        s.close();
    }
}
