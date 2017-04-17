package taursus.remoteControlServer;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import com.remoteControl.ILogger;
import com.remoteControl.IOptionsControl;

public class LinuxOptionsControl implements IOptionsControl {
    protected Robot robot;
    protected ILogger logger;

    public LinuxOptionsControl(Robot robot, ILogger logger) {
        this.robot = robot;
        this.logger = logger;
    }
    
    protected LinuxOptionsControl exec(String cmd) {
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return this;
    }

    @Override
    public LinuxOptionsControl shutdown() {
        this.logger.log("Executing option", "shutdown");
        exec("shutdown -h now");
        return this;
    }

    @Override
    public LinuxOptionsControl hibernate() {
        this.logger.log("Executing option", "hibernate");
        exec("systemctl suspend");
        return this;
    }

    @Override
    public LinuxOptionsControl restart() {
        this.logger.log("Executing option", "restart");
        exec("shutdown -r now");
        return this;
    }

    @Override
    public LinuxOptionsControl taskManager() {
        this.logger.log("Executing option", "taskManager");
        exec("gnome-system-monitor");
        return this;
    }

    @Override
    public LinuxOptionsControl turnOffMonitor() {
        this.logger.log("Executing option", "turnOffMonitor");
        exec("xset -display :0.0 dpms force off ");
        return this;
    }

    @Override
    public LinuxOptionsControl volumeDown() {
        this.logger.log("Executing option", "volumeDown");
        exec("amixer -D pulse sset Master 5%-");
        return this;
    }

    @Override
    public LinuxOptionsControl volumeUp() {
        this.logger.log("Executing option", "volumeUp");
        exec("amixer -D pulse sset Master 5%+");
        return this;
    }

    @Override
    public LinuxOptionsControl soundMute() {
        this.logger.log("Executing option", "soundMute");
        exec("amixer -q -D pulse sset Master toggle");
        return this;
    }

    @Override
    public LinuxOptionsControl printScreen() {
        this.logger.log("Executing option", "printScreen");

        this.robot.keyPress(KeyEvent.VK_PRINTSCREEN);
        this.robot.delay(10);
        this.robot.keyRelease(KeyEvent.VK_PRINTSCREEN);
        return this;
    }

    @Override
    public LinuxOptionsControl ctrlAltDelete() {
        this.logger.log("Executing option", "ctrlAltDelete");

        this.robot.keyPress(KeyEvent.VK_CONTROL);
        this.robot.keyPress(KeyEvent.VK_ALT);
        this.robot.keyPress(KeyEvent.VK_DELETE);

        this.robot.delay(10);

        this.robot.keyRelease(KeyEvent.VK_DELETE);
        this.robot.keyRelease(KeyEvent.VK_ALT);
        this.robot.keyRelease(KeyEvent.VK_CONTROL);
        return this;
    }

    @Override
    public LinuxOptionsControl commandKey() {
        this.logger.log("Executing option", "commandKey");

        this.robot.keyPress(KeyEvent.VK_WINDOWS);
        this.robot.delay(10);
        this.robot.keyRelease(KeyEvent.VK_WINDOWS);
        return this;
    }
}
