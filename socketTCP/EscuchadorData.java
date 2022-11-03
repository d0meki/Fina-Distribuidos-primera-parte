/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketTCP;

import Objetos.SuperClase;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author domek
 */
public class EscuchadorData extends Thread {

    private transient Socket cliente;
    private DataInputStream in;
    private List<ConnectionData> escuchadorData;
    private boolean stado;
    private String mensaje;
    private String clienteID;

    public EscuchadorData(Socket cliente) {
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
                try {
                    this.mensaje = this.in.readUTF(); // yo estoy esperando a que el cliente me mande algo
                    //System.out.println(mensaje);

                    Gson gson = new Gson();
                    SuperClase sc = gson.fromJson(this.mensaje, SuperClase.class);
                    String json = gson.toJson(sc.getClase());
                    switch (sc.getIdentificador()) {
                        case "Login":
                            notificarLogin(this.mensaje);
                            break;
                        case "Register":
                            notificarRegister(this.mensaje);
                            break;
                        case "LogOut":
                            System.out.println("LogOut por un Boton");
                            this.stado = false;
                            //cambiar el estado del ClienteConectado a False
                            break;
                        case "Matriz":
                            notificarMensaje(this.mensaje);
                            break;
                        case "Juego":
                            notificarJuego(this.mensaje);
                            break;
                        case "Ganador":
                            notificarGanador(this.mensaje);
                            break;    
                        default:
                            notificarMensaje(this.mensaje);

                    }
                } catch (Exception e) {
                    System.out.println("El CLiente Se desconectó Bruscamente Por X");
                    this.stado = false;
                }
            }
        } catch (Exception e) {
            System.out.println("Cerré el Hilo con X");
        }
    }

    public void notificarMensaje(String mensaje) throws IOException {
        MyEventData myEvData = new MyEventData(this, this.cliente, mensaje);
        for (ConnectionData ev : this.escuchadorData) {
            ev.OnRead(myEvData);
        }
    }

    public void notificarLogin(String mensaje) throws IOException {
        MyEventData myEvData = new MyEventData(this, this.cliente, mensaje);
        for (ConnectionData ev : this.escuchadorData) {
            ev.OnLogin(myEvData);
        }
    }

    public void notificarRegister(String mensaje) throws IOException {
        MyEventData myEvData = new MyEventData(this, this.cliente, mensaje);
        for (ConnectionData ev : this.escuchadorData) {
            ev.OnRegister(myEvData);
        }
    }
    public void notificarJuego(String mensaje) throws IOException {
        MyEventData myEvData = new MyEventData(this, this.cliente, mensaje);
        for (ConnectionData ev : this.escuchadorData) {
            ev.OnEmpezarJuego(myEvData);
        }
    }
    public void notificarGanador(String mensaje) throws IOException {
        MyEventData myEvData = new MyEventData(this, this.cliente, mensaje);
        for (ConnectionData ev : this.escuchadorData) {
            ev.OnGanador(myEvData);
        }
    }

    public void addEventDataListener(ConnectionData dataListener) {
        this.escuchadorData.add(dataListener);
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public DataInputStream getIn() {
        return in;
    }

    public void setIn(DataInputStream in) {
        this.in = in;
    }

    public List<ConnectionData> getEscuchadorData() {
        return escuchadorData;
    }

    public void setEscuchadorData(List<ConnectionData> escuchadorData) {
        this.escuchadorData = escuchadorData;
    }

    public boolean isStado() {
        return stado;
    }

    public void setStado(boolean stado) {
        this.stado = stado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
