package socketTCP;

import Objetos.SuperClase;
import com.google.gson.Gson;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;

public class Tarea extends Thread {

    private DataOutputStream out;
    private Socket cliente;
    private String mensaje;

    public Tarea() {
        this.cliente = null;
        this.mensaje = "";
    }

    public Tarea(Socket cliente) {
        this.cliente = cliente;
        this.mensaje = "";
    }

    public Tarea(Socket cliente, String msj) {
        this.cliente = cliente;
        this.mensaje = msj;
    }

    @Override
    public void run() {
        try {
            this.out = new DataOutputStream(this.cliente.getOutputStream());
            out.writeUTF(this.mensaje);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
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

class Comentarios {
    //  ----------------------Estaba tratando de recorrer dentro del TASK----------------------------- 
    //            Enumeration<String> e = this.clientesConectados.keys();
//            while (e.hasMoreElements()) {
//                String key = e.nextElement();
//                if (!key.equals(this.idCliente)) {
//                    MyEvento myEv = (MyEvento) this.clientesConectados.get(key);
//                    this.out = new DataOutputStream(myEv.getCliente().getOutputStream());
//                    out.writeUTF(this.mensaje);
//                }
//            }

}
