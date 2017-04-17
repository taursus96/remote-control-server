package taursus.remoteControlServer;

import java.awt.Robot;
import java.awt.event.InputEvent;

import taursus.remoteControl.*;

public class MouseControl implements IMouseControl {
    protected Robot robot;
    protected IMouseMovementStrategy mouseMovementStrategy;
    protected ILogger logger;

    MouseControl(Robot robot, IMouseMovementStrategy mouseMovementStrategy, ILogger logger) {
        this.robot = robot;
        this.mouseMovementStrategy = mouseMovementStrategy;
        this.logger = logger;
    }

    @Override
    public IMouseControl moveCursor(short x, short y) {
        this.logger.log("Mouse move", String.format("(%d, %d)", x, y));
        this.mouseMovementStrategy.move(x, y);
        return this;
    }

    @Override
    public IMouseControl leftButtonPress() {
        this.logger.log("Executing mouse event", "left button press");
        this.robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        this.robot.delay(10);
        return this;
    }

    @Override
    public IMouseControl leftButtonRelease() {
        this.logger.log("Executing mouse event", "left button releas");
        this.robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        return this;
    }

    @Override
    public IMouseControl rightButtonPress() {
        this.logger.log("Executing mouse event", "right button press");
        this.robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        this.robot.delay(10);
        return this;
    }

    @Override
    public IMouseControl rightButtonRelease() {
        this.logger.log("Executing mouse event", "left button release");
        this.robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        return this;
    }

    @Override
    public IMouseControl middleButtonPress() {
        this.logger.log("Executing mouse event", "middle button press");
        this.robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
        this.robot.delay(10);
        return null;
    }

    @Override
    public IMouseControl middleButtonRelease() {
        this.logger.log("Executing mouse event", "middle button release");
        this.robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
        return null;
    }

    @Override
    public IMouseControl scroll(short amount) {
        this.logger.log("Executing mouse event", String.format("scroll %d", amount));
        this.robot.mouseWheel(amount);
        return null;
    }
}
