/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketTCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.EventObject;

public class MyEventData extends EventObject{
    private transient Socket cliente;
    private String mensaje;
    private String nombreCliente;
    public MyEventData(Object obj,Socket cliente, String mensaje) throws IOException {
        super(obj);
        this.cliente = cliente;
        this.nombreCliente = cliente.getInetAddress().getHostName();
        this.mensaje = mensaje;
    }
    public String getClienteName() {
        return nombreCliente;
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
