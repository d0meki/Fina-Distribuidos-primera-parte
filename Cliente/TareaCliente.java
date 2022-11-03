package Cliente;

import Objetos.SuperClase;
import com.google.gson.Gson;
import java.io.DataOutputStream;
import java.net.Socket;

public class TareaCliente extends Thread {

    private DataOutputStream out;
    private SuperClase sc;
    private String mensaje;
    private Socket cliente;

    public TareaCliente(SuperClase mensaje, Socket cliente) {
        this.cliente = cliente;
        this.sc = mensaje;
        Gson gson = new Gson();
        this.mensaje = gson.toJson(sc);
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public SuperClase getSc() {
        return sc;
    }

    public void setSc(SuperClase sc) {
        this.sc = sc;
    }
    

}
