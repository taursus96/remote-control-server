package taursus.remoteControlServer;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import com.remoteControl.ILogger;
import com.remoteControl.IOptionsControl;

public class WindowsOptionsControl implements IOptionsControl {
    protected Robot robot;
    protected ILogger logger;

    public WindowsOptionsControl(Robot robot, ILogger logger) {
        this.robot = robot;
        this.logger = logger;
    }

    protected WindowsOptionsControl exec(String cmd) {
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return this;
    }
    
    @Override
    public WindowsOptionsControl shutdown() {
        this.logger.log("Executing option", "shutdown");
        exec("shutdown -s -t 0");
        return this;
    }

    @Override
    public WindowsOptionsControl hibernate() {
        this.logger.log("Executing option", "hibernate");
        exec("shutdown -h -t 0");
        return this;
    }

    @Override
    public WindowsOptionsControl restart() {
        this.logger.log("Executing option", "restart");
        exec("shutdown -r -t 0");
        return this;
    }

    @Override
    public WindowsOptionsControl taskManager() {
        this.logger.log("Executing option", "taskManager");
        exec("taskmgr");
        return this;
    }

    @Override
    public WindowsOptionsControl turnOffMonitor() {
        this.logger.log("Executing option", "turnOffMonitor");
        exec("nircmd.exe monitor off");
        return this;
    }

    @Override
    public WindowsOptionsControl volumeDown() {
        this.logger.log("Executing option", "volumeDown");
        int amount = (int) Math.floor(65535 * 0.05);
        exec(String.format("nircmd.exe changesysvolume -%d", amount));
        return this;
    }

    @Override
    public WindowsOptionsControl volumeUp() {
        this.logger.log("Executing option", "volumeUp");
        int amount = (int) Math.floor(65535 * 0.05);
        exec(String.format("nircmd.exe changesysvolume %d", amount));
        return this;
    }

    @Override
    public WindowsOptionsControl soundMute() {
        this.logger.log("Executing option", "soundMute");
        exec("nircmd.exe mutesysvolume 2");
        return this;
    }

    @Override
    public WindowsOptionsControl printScreen() {
        this.logger.log("Executing option", "printScreen");

        this.robot.keyPress(KeyEvent.VK_PRINTSCREEN);
        this.robot.delay(10);
        this.robot.keyRelease(KeyEvent.VK_PRINTSCREEN);
        return this;
    }

    @Override
    public WindowsOptionsControl ctrlAltDelete() {
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
    public WindowsOptionsControl commandKey() {
        this.logger.log("Executing option", "commandKey");

        this.robot.keyPress(KeyEvent.VK_WINDOWS);
        this.robot.delay(10);
        this.robot.keyRelease(KeyEvent.VK_WINDOWS);
        return this;
    }
}
