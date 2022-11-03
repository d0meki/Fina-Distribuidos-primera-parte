package Cliente;

import java.util.EventListener;
import socketTCP.MyEventData;

public interface DataListenner extends EventListener{
    public void OnRead(MyEventoDataCliente evt);
}
