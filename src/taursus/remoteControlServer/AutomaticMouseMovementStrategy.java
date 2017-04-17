package taursus.remoteControlServer;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

public class AutomaticMouseMovementStrategy implements IMouseMovementStrategy {
    protected Robot robot;
    protected IMouseMovementSensitivityStrategy sensitivityStrategy;

    public AutomaticMouseMovementStrategy(Robot robot, IMouseMovementSensitivityStrategy sensitivityStrategy) {
        this.robot = robot;
        this.sensitivityStrategy = sensitivityStrategy;
    }

    @Override
    public void move(short x, short y) {
        Point point = MouseInfo.getPointerInfo().getLocation();
        int moveX = this.sensitivityStrategy.applySensitivity(x);
        int moveY = this.sensitivityStrategy.applySensitivity(y);

        this.robot.mouseMove(point.x + moveX, point.y + moveY);
    }

    public void close() {

    }
}
