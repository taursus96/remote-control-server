package taursus.remoteControlServer;

public class MouseMovementSensitivityStrategyFactory {

    public static IMouseMovementSensitivityStrategy create() {
        return new MouseMovementPowerSensitivityStrategy();
    }
}
