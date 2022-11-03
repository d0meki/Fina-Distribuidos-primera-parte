
package socketTCP;

import java.util.EventListener;

public interface ConnectionListener extends EventListener{
    //public void onTextoEditado(Procesador procesador);    
    public void onConnect(MyEvento evt);
    public void onDisconnect(MyEvento evt);
}
