package taursus.remoteControlServer;

public class MouseMovementPowerSensitivityStrategy implements IMouseMovementSensitivityStrategy {
    protected float exponent = 1.2f;

    public MouseMovementPowerSensitivityStrategy() {
    }

    public MouseMovementPowerSensitivityStrategy(float exponent) {
        setExponent(exponent);
    }

    public void setExponent(float exponent) {
        this.exponent = exponent;
    }

    public int applySensitivity(int value) {
        boolean isNegative = value < 0;
        value = (int) Math.pow(Math.abs(value), this.exponent);
        return (isNegative ? value * -1 : value);
    }
}
