/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author domek
 */
public class Escuchador extends Thread{

    //private DataInputStream in;
    private DataOutputStream out;
    private ServerSocket server;
    private Socket socketclient;
    private boolean stado;
    private List<ConnectionListener> listaEscuchadores;

    public Escuchador(ServerSocket server) {
        this.server = server;
        this.stado = true;
        this.listaEscuchadores = new ArrayList();
    }

    @Override
    public void run() {
        try {
            while (this.stado) {
                this.socketclient = this.server.accept();//se queda a la espera - es ese tuvo que comunica con el cliente 
                notificarCliente();
                
               
                
                //aqui crear el metodo notificar clientes
                
                //System.out.println("Cliente conectado");
         //       in = new DataInputStream(socketclient.getInputStream()); //recibir los mensajes del cliente  ///  hay diferentes tipos de Stream
//                out = new DataOutputStream(socketclient.getOutputStream()); ///  DATA para string, otro para arreglos de byte y otro para objetos
//
        //        String mensaje = in.readUTF(); // yo estoy esperando a que el cliente me mande algo
//
        //        System.out.println(mensaje);
//
//                out.writeUTF("Hola mundo desde el servidor!");
//
//                socketclient.close();//cerrando el cliente
//
//                System.out.println("Cliente desconectado");
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
    public void addEvenListener(ConnectionListener s){        
        this.listaEscuchadores.add(s);
    }
    public void notificarCliente(){
       MyEvento myEv = new MyEvento(this,this.socketclient); 
        for (ConnectionListener ev: this.listaEscuchadores) {//corregir
            ev.onConnect(myEv);
        }
    }
    public Socket getSocketclient() {
        return socketclient;
    }
    public DataOutputStream getOut() {
        return out;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    public ServerSocket getServer() {
        return server;
    }

    public void setServer(ServerSocket server) {
        this.server = server;
    }

    public boolean isStado() {
        return stado;
    }

    public void setStado(boolean stado) {
        this.stado = stado;
    }

    public List<ConnectionListener> getListaEscuchadores() {
        return listaEscuchadores;
    }

    public void setListaEscuchadores(List<ConnectionListener> listaEscuchadores) {
        this.listaEscuchadores = listaEscuchadores;
    }
    
}
