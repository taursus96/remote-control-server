package taursus.remoteControlServer;

import com.remoteControl.*;

public class OptionsEventsExecutor extends EventDataReceiver {
    protected IOptionsControl optionsControl;

    public OptionsEventsExecutor(Transporter transporter, IEventDataSerializer eventDataSerializer,
            IOptionsControl optionsControl) {
        super(transporter, eventDataSerializer);
        this.optionsControl = optionsControl;
    }

    public void processEvent(IEventData event) {
        switch (event.getType()) {
        case IEventData.EVENT_OPTION_SHUTDOWN:
            this.optionsControl.shutdown();
            break;
        case IEventData.EVENT_OPTION_HIBERNATE:
            this.optionsControl.hibernate();
            break;
        case IEventData.EVENT_OPTION_RESTART:
            this.optionsControl.restart();
            break;
        case IEventData.EVENT_OPTION_PRINT_SCREEN:
            this.optionsControl.printScreen();
            break;
        case IEventData.EVENT_OPTION_TASK_MANAGER:
            this.optionsControl.taskManager();
            break;
        case IEventData.EVENT_OPTION_CTRL_ALT_DELETE:
            this.optionsControl.ctrlAltDelete();
            break;
        case IEventData.EVENT_OPTION_COMMAND_KEY:
            this.optionsControl.commandKey();
            break;
        case IEventData.EVENT_OPTION_TURN_OFF_MONITOR:
            this.optionsControl.turnOffMonitor();
            break;
        case IEventData.EVENT_OPTION_VOLUME_UP:
            this.optionsControl.volumeUp();
            break;
        case IEventData.EVENT_OPTION_VOLUME_DOWN:
            this.optionsControl.volumeDown();
            break;
        case IEventData.EVENT_OPTION_SOUND_MUTE:
            this.optionsControl.soundMute();
            break;
        }
    }
}
