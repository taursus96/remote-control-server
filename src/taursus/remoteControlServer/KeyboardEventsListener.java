package taursus.remoteControlServer;

import taursus.remoteControl.EventDataReceiver;
import taursus.remoteControl.IEventData;
import taursus.remoteControl.IEventDataSerializer;
import taursus.remoteControl.IKeyboardControl;
import taursus.remoteControl.ILogger;
import taursus.remoteControl.ITransporter;

public class KeyboardEventsListener extends EventDataReceiver {
    protected IKeyboardControl keyboardControl;

    public KeyboardEventsListener(ITransporter transporter, IEventDataSerializer eventDataSerializer,
            IKeyboardControl keyboardControl) {
        super(transporter, eventDataSerializer);
        this.keyboardControl = keyboardControl;
    }

    public void processEvent(IEventData event) {
        switch (event.getType()) {

        case IEventData.EVENT_KEY_PRESSED:
            this.keyboardControl.pressKey(event.getKeyCode());
            break;
        case IEventData.EVENT_KEY_RELEASED:
            this.keyboardControl.releaseKey(event.getKeyCode());
            break;
        }
    }
}
