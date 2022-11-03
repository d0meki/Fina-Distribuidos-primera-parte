
package socketTCP;

import Protocolos.Register;
import java.net.Socket;
import java.util.Date;
import java.util.EventObject;

public class MyEvento extends EventObject{
    private transient Socket cliente;
    private String ip;
    private String hostname;
    private Date fecha;
    private String id; 
    private Register register;
    private transient EscuchadorData escuchador;
    private boolean conectado;

     public MyEvento(Object obj) { //socket
        super(obj);
    }
    public MyEvento(Object obj, Socket cliente) { //socket
        super(obj);
        this.cliente = cliente;
        this.ip = cliente.getInetAddress().getHostAddress();
        this.hostname = cliente.getInetAddress().getHostName();
        this.fecha = new Date();
        this.id = generadorId();//hascode;
        this.register = new Register();
        this.conectado = false;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }
   
    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EscuchadorData getEscuchador() {
        return escuchador;
    }

    public void setEscuchador(EscuchadorData escuchador) {
        this.escuchador = escuchador;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    private String generadorId() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String autoId = "";
        for (int i = 0; i < 20; i++) {
            autoId += chars.charAt((int) Math.floor(Math.random() * chars.length()));
        }
        return autoId;
    }

}
