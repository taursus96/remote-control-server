package taursus.remoteControlServer;

import java.awt.Robot;

import org.apache.commons.lang3.SystemUtils;

public class MouseMovementStrategyFactory {

    public static IMouseMovementStrategy create(Robot robot) {
        /*
         * Ubuntu smoothes mouse movement automatically and it does it better
         * than ManualMouseMovementStrategy so I guess every linux distro will
         * behave this way but if you know that it doesn't let me know
         */

        IMouseMovementSensitivityStrategy sensitivityStrategy = MouseMovementSensitivityStrategyFactory.create();

        if (SystemUtils.IS_OS_LINUX) {
            return (IMouseMovementStrategy) new AutomaticMouseMovementStrategy(robot, sensitivityStrategy);
        }

        return (IMouseMovementStrategy) new ManualMouseMovementStrategy(robot, sensitivityStrategy);
    }
}
