package socketUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author domek
 */
public class Cliente {
    public static void main(String[] args){
        
        final int PUERTO_SERVIDOR = 5000;
        byte[] buffer = new byte[1024];
       
        try {
            
            InetAddress direccionServidor = InetAddress.getByName("localhost");
            
            DatagramSocket socketUDP = new DatagramSocket(); //te va asignar un puerto propio o generar
            String mensaje = "!Hola mundo desde el cliente";
            
            buffer = mensaje.getBytes();
            
            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
            
            
            System.out.println("Envio el datagrama");
            
            socketUDP.send(pregunta);
            
            DatagramPacket peticion = new DatagramPacket(buffer,buffer.length);
        
            socketUDP.receive(peticion);
            
            
            mensaje =  new String(peticion.getData());
            System.out.println("Recivo peticion");
            System.out.println(mensaje);
            
            socketUDP.close();
            
            
        } catch (SocketException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
}
