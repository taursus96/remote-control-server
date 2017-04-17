package taursus.remoteControlServer;

import org.apache.commons.lang3.SystemUtils;

import taursus.remoteControl.EventData;
import taursus.remoteControl.EventDataSender;
import taursus.remoteControl.IEventData;
import taursus.remoteControl.IEventDataSerializer;
import taursus.remoteControl.IOnConnected;
import taursus.remoteControl.ITransporter;

public class OSSender extends EventDataSender implements IOnConnected {
    public OSSender(ITransporter transporter, IEventDataSerializer serializer) {
        super(transporter, serializer);
        transporter.registerOnConnectedListener(this);
    }

    public void onConnected() {
        IEventData data = new EventData();
        data.setType(IEventData.EVENT_OS);

        if (SystemUtils.IS_OS_WINDOWS) {
            data.setOS(IEventData.OS_WINDOWS);
        } else if (SystemUtils.IS_OS_LINUX) {
            data.setOS(IEventData.OS_LINUX);
        } else if (SystemUtils.IS_OS_MAC) {
            data.setOS(IEventData.OS_MAC);
        }

        this.sendEventData(data);
    }
}
