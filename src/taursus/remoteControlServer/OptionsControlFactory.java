package taursus.remoteControlServer;

import java.awt.Robot;

import org.apache.commons.lang3.SystemUtils;

import com.remoteControl.IOptionsControl;

public class OptionsControlFactory {

    public static IOptionsControl create(Robot robot) {
        if (SystemUtils.IS_OS_WINDOWS) {
            return new WindowsOptionsControl(robot, LoggerFactory.create());
        } else if (SystemUtils.IS_OS_LINUX) {
            return new LinuxOptionsControl(robot, LoggerFactory.create());
        }

        return null;
    }
}
