/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import socketTCP.ConnectionData;
import socketTCP.MyEventData;

/**
 *
 * @author USUARIO
 */
public class EscuchadorDataCliente extends Thread {

    private Socket cliente;
    private DataInputStream in;
    private List<DataListenner> escuchadorData;
    private boolean stado;
    private String mensaje;

    public EscuchadorDataCliente(Socket cliente){
        this.cliente = cliente;
        this.stado = true;
        this.escuchadorData = new ArrayList();
        this.mensaje = "";
    }

    @Override
    public void run() {
        try {
            this.in = new DataInputStream(this.cliente.getInputStream());
            while (stado) {
                this.mensaje = this.in.readUTF();
                notificarMensaje(mensaje);
            }
        } catch (IOException ex) {
            
        }
    }

    public void notificarMensaje(String mensaje) throws IOException {
        MyEventoDataCliente myEvData = new MyEventoDataCliente(this, this.cliente, mensaje);
        for (DataListenner ev : this.escuchadorData) {
            ev.OnRead(myEvData);
        }
    }
    
    public void addEventDataListener(DataListenner dataListener) {
        this.escuchadorData.add(dataListener);
    }
     
}
