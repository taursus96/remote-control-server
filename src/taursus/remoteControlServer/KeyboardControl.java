package taursus.remoteControlServer;

import java.awt.Robot;

import com.remoteControl.IKeyboardControl;
import com.remoteControl.ILogger;

public class KeyboardControl implements IKeyboardControl {
    protected Robot robot;
    protected ILogger logger;

    KeyboardControl(Robot robot, ILogger logger) {
        this.robot = robot;
        this.logger = logger;
    }

    @Override
    public IKeyboardControl pressKey(int key) {
        this.logger.log("Executing keyboard event", String.format("key press %d", key));
        this.robot.keyPress(key);
        return this;
    }

    @Override
    public IKeyboardControl releaseKey(int key) {
        this.logger.log("Executing keyboard event", String.format("key release %d", key));
        this.robot.keyRelease(key);
        return this;
    }

}
