package taursus.remoteControlServer;

import com.remoteControl.*;

public class MouseEventsListener extends EventDataReceiver {
    protected IMouseControl mouseControl;

    public MouseEventsListener(Transporter transporter, IEventDataSerializer eventDataSerializer,
            IMouseControl mouseControl) {
        super(transporter, eventDataSerializer);
        this.mouseControl = mouseControl;
    }

    public void processEvent(IEventData event) {
        switch (event.getType()) {
        case IEventData.EVENT_MOVE_MOUSE:
            this.mouseControl.moveCursor(event.getMoveMouseX(), event.getMoveMouseY());
            break;
        case IEventData.EVENT_PRESSED_LEFT_MOUSE_BUTTON:
            this.mouseControl.leftButtonPress();
            break;
        case IEventData.EVENT_RELEASED_LEFT_MOUSE_BUTTON:
            this.mouseControl.leftButtonRelease();
            break;
        case IEventData.EVENT_PRESSED_RIGHT_MOUSE_BUTTON:
            this.mouseControl.rightButtonPress();
            break;
        case IEventData.EVENT_RELEASED_RIGHT_MOUSE_BUTTON:
            this.mouseControl.rightButtonRelease();
            break;
        case IEventData.EVENT_PRESSED_MIDDLE_MOUSE_BUTTON:
            this.mouseControl.middleButtonPress();
            break;
        case IEventData.EVENT_RELEASED_MIDDLE_MOUSE_BUTTON:
            this.mouseControl.middleButtonRelease();
            break;
        case IEventData.EVENT_SCROLL:
            this.mouseControl.scroll(event.getScroll());
            break;
        }
    }
}
