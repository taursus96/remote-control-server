package taursus.remoteControlServer;

public interface IMouseMovementStrategy {
    public void move(short x, short y);

    public void close();
}
