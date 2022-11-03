/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package socketTCP;

import java.util.EventListener;

/**
 *
 * @author domek
 */
public interface ConnectionData extends EventListener{
   // public void OnRegister(MyEventoReg evt);
    public void OnRead(MyEventData evt);
    public void OnLogin(MyEventData evt);
    public void OnRegister(MyEventData evt);
    public void OnEmpezarJuego(MyEventData evt);
    public void OnGanador(MyEventData evt);
}
