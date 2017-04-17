package taursus.remoteControlServer;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

public class ManualMouseMovementStrategy implements IMouseMovementStrategy, Runnable {
    protected Robot robot;
    protected Thread thread;
    protected IMouseMovementSensitivityStrategy sensitivityStrategy;
    protected boolean isRunning = false;

    protected int targetX = 0;
    protected int targetY = 0;

    protected float accumulatedMoveX = 0;
    protected float accumulatedMoveY = 0;

    protected float stepTargetDivider = 10;
    protected int delayAfterEachStep = 5;

    public ManualMouseMovementStrategy(Robot robot, IMouseMovementSensitivityStrategy sensitivityStrategy) {
        this.robot = robot;
        this.sensitivityStrategy = sensitivityStrategy;

        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void move(short x, short y) {
        this.targetX += this.sensitivityStrategy.applySensitivity(x);
        this.targetY += this.sensitivityStrategy.applySensitivity(y);
    }

    @Override
    public void run() {
        this.isRunning = true;

        while (this.isRunning) {
            moveToTarget();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        this.isRunning = false;
    }

    protected void moveToTarget() {
        this.accumulatedMoveX = 0;
        this.accumulatedMoveY = 0;

        while (this.targetX != 0 && this.targetY != 0) {
            Point point = MouseInfo.getPointerInfo().getLocation();

            this.accumulatedMoveX += this.targetX / this.stepTargetDivider;
            this.accumulatedMoveY += this.targetY / this.stepTargetDivider;

            int stepMoveX = (int) this.accumulatedMoveX;
            int stepMoveY = (int) this.accumulatedMoveY;

            if (stepMoveX != 0 || stepMoveY != 0) {
                this.robot.mouseMove(point.x + stepMoveX, point.y + stepMoveY);
                this.robot.delay(this.delayAfterEachStep);

                this.targetX -= stepMoveX;
                this.targetY -= stepMoveY;
                this.accumulatedMoveX -= stepMoveX;
                this.accumulatedMoveY -= stepMoveY;
            }
        }
    }
}