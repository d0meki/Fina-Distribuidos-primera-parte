/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.IOException;
import java.net.Socket;
import java.util.EventObject;
import socketTCP.ConnectionData;
import socketTCP.MyEventData;

/**
 *
 * @author USUARIO
 */
public class MyEventoDataCliente extends EventObject {

    private Socket cliente;
    private String mensaje;

    public MyEventoDataCliente(Object obj,Socket cliente, String mensaje) {
        super(obj);
        this.cliente = cliente;
        this.mensaje = mensaje;
    }
    

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
