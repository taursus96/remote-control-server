package taursus.remoteControlServer;

import com.remoteControl.EventDataReceiver;
import com.remoteControl.IEventData;
import com.remoteControl.IEventDataSerializer;
import com.remoteControl.IKeyboardControl;
import com.remoteControl.ILogger;
import com.remoteControl.ITransporter;

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
