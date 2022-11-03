package socketTCP;

import Objetos.SuperClase;
import Protocolos.AsigId;
import Protocolos.Login;
import Protocolos.Matriz;
import Protocolos.Notificacion;
import Protocolos.Register;
import Protocolos.Start;
import Protocolos.Usuario;
import Protocolos.Winner;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Server implements ConnectionListener, ConnectionData {

    private Escuchador escuchador;
    private ServerSocket server;
    private HashMap<String, MyEvento> clientesConectados;
    private EscuchadorData escuchadorDeData;
    private Gson gson;

    public Server() {
        try {
            this.server = new ServerSocket(5000);
            this.escuchador = new Escuchador(this.server);
            this.gson = new Gson();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void iniciarServidor() {
        System.out.println("Servidor Escuchando");
        leerJSON();
        this.escuchador.addEvenListener(this);
        this.escuchador.start();
    }

    private void leerJSON() {
        try {
            FileInputStream fichero = new FileInputStream("src/Fichero/registrados.txt");
            ObjectInputStream tuberia = new ObjectInputStream(fichero);
            this.clientesConectados = (HashMap<String, MyEvento>) tuberia.readObject();

            if (this.clientesConectados == null) {
                this.clientesConectados = new HashMap();
            } else {
                for (HashMap.Entry<String, MyEvento> cliente : this.clientesConectados.entrySet()) {
                    cliente.getValue().setConectado(false);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onConnect(MyEvento evt) {  //evt tiene toda la informacion de quien se conectó           
        System.out.println("Se acaba de conectar el Cliente: " + evt.getHostname() + " | Id Asignado: " + evt.getId());
        this.escuchadorDeData = new EscuchadorData(evt.getCliente()); //creando la isntancia antes de agregar a la lista       
        this.escuchadorDeData.addEventDataListener(this);
        this.escuchadorDeData.start();

        AsigId aid = new AsigId(evt.getId());
        SuperClase sc = new SuperClase("Id", aid);
        Tarea enviarIdAlCliente = new Tarea(evt.getCliente(), gson.toJson(sc));
        enviarIdAlCliente.start();
        evt.setEscuchador(this.escuchadorDeData);
        this.clientesConectados.put(evt.getId(), evt);
    }

    @Override
    public void onDisconnect(MyEvento evt) {
        System.out.println("Se acaba de desconectar un cliente");
        this.clientesConectados.remove(evt.getId());
    }

    @Override
    public void OnRead(MyEventData evt) {
        SuperClase sc = gson.fromJson(evt.getMensaje(), SuperClase.class);
        String json = gson.toJson(sc.getClase());
        Matriz m = gson.fromJson(json, Matriz.class);
        for (HashMap.Entry<String, MyEvento> clienteAEnviar : this.clientesConectados.entrySet()) {
            if (clienteAEnviar.getValue().isConectado() && !m.getKey().equals(clienteAEnviar.getKey())) {
                Tarea enviarLista = new Tarea(clienteAEnviar.getValue().getCliente(), gson.toJson(sc));
                enviarLista.start();
            }
        }
    }

    @Override
    public void OnLogin(MyEventData evt) {
        SuperClase sc = gson.fromJson(evt.getMensaje(), SuperClase.class);

        String json = gson.toJson(sc.getClase());
        //--notificaciones--
        Notificacion ntf = new Notificacion();
        SuperClase superclase = new SuperClase();
        superclase.setIdentificador("Notificacion");
        Tarea tnotificacion = new Tarea(evt.getCliente());
        //--FIN definicion de notificaciones--
        Login login = gson.fromJson(json, Login.class);

        boolean usuarioAuth = validar(login);
        if (usuarioAuth) {
            HashMap lista = new HashMap();
            for (HashMap.Entry<String, MyEvento> cliente : this.clientesConectados.entrySet()) {
                if (cliente.getValue().isConectado()) {
                    Usuario user = new Usuario(cliente.getValue().getRegister().getUser(), cliente.getValue().isConectado());
                    String userJson = gson.toJson(user);
                    lista.put(cliente.getValue().getRegister().getKey(), userJson);
                }
            }
            SuperClase superClass = new SuperClase("Lista", lista);
            for (HashMap.Entry<String, MyEvento> clienteAEnviar : this.clientesConectados.entrySet()) {
                if (clienteAEnviar.getValue().isConectado()) {
                    //   Tarea enviarLista = new Tarea(evt.getCliente(), gson.toJson(superClass));
                    Tarea enviarLista = new Tarea(clienteAEnviar.getValue().getCliente(), gson.toJson(superClass));
                    enviarLista.start();
                }
            }

        } else {
            ntf.setMensaje("Usuario o contraseña incorrectos");
            superclase.setClase(ntf);
            tnotificacion.setMensaje(gson.toJson(superclase));
            tnotificacion.start();
        }
    }

    @Override
    public void OnRegister(MyEventData evt) {
        SuperClase sc = gson.fromJson(evt.getMensaje(), SuperClase.class);
        String json = gson.toJson(sc.getClase());
        //--notificaciones--
        Notificacion ntf = new Notificacion();
        SuperClase superclase = new SuperClase();
        superclase.setIdentificador("Notificacion");
        Tarea tnotificacion = new Tarea(evt.getCliente());
        //--FIN definicion de notificaciones--
        Register register = gson.fromJson(json, Register.class);
        MyEvento clte = (MyEvento) this.clientesConectados.get(register.getKey());
        if (clte != null) {
            if (register.getKey().equals(clte.getId())) {
                if (!ExisteUsuario(register.getUser())) {
                    clte.setRegister(register);
                    guardarEnUnJSON();
                    ntf.setMensaje("Registrado Correctamente");
                    superclase.setClase(ntf);
                } else {
                    ntf.setMensaje("Usuario ya Existe");
                    superclase.setClase(ntf);
                }
            } else {
                ntf.setMensaje("Error ID de ese Usuario");
                superclase.setClase(ntf);
            }
        } else {
            ntf.setMensaje("No existe Usuario");
            superclase.setClase(ntf);
        }
        tnotificacion.setMensaje(gson.toJson(superclase));
        tnotificacion.start();
    }

    @Override
    public void OnEmpezarJuego(MyEventData evt) {
        SuperClase sc = gson.fromJson(evt.getMensaje(), SuperClase.class);
        String json = gson.toJson(sc.getClase());
        Start start = gson.fromJson(json, Start.class);
        for (HashMap.Entry<String, MyEvento> clienteAEnviar : this.clientesConectados.entrySet()) {
            if (clienteAEnviar.getValue().isConectado() && !start.getKey().equals(clienteAEnviar.getKey())) {
                Tarea enviarLista = new Tarea(clienteAEnviar.getValue().getCliente(), gson.toJson(sc));
                enviarLista.start();
            }
        }
    }

    @Override
    public void OnGanador(MyEventData evt) {
        SuperClase sc = gson.fromJson(evt.getMensaje(), SuperClase.class);
        String json = gson.toJson(sc.getClase());
        Winner w = gson.fromJson(json, Winner.class);
        for (HashMap.Entry<String, MyEvento> clienteAEnviar : this.clientesConectados.entrySet()) {
            if (clienteAEnviar.getValue().isConectado() && !w.getKey().equals(clienteAEnviar.getKey())) {
                Tarea enviarLista = new Tarea(clienteAEnviar.getValue().getCliente(), gson.toJson(sc));
                enviarLista.start();
            }
        }
    }

    private boolean ExisteUsuario(String usuario) {
        for (HashMap.Entry<String, MyEvento> cliente : this.clientesConectados.entrySet()) {
            // this.clientesConectados.put(entry.getKey(), entry.getValue());
            if (cliente.getValue().getRegister().getUser().equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    private void guardarEnUnJSON() {
        try {
            FileOutputStream fichero = new FileOutputStream("src/Fichero/registrados.txt");
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(this.clientesConectados);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean validar(Login login) {
        MyEvento clienteActual = (MyEvento) this.clientesConectados.get(login.getKey());
        String userLogin = login.getUser();
        String passLogin = login.getPassword();
        for (HashMap.Entry<String, MyEvento> cliente : this.clientesConectados.entrySet()) {
            if (!cliente.getKey().equals(login.getKey())) {
                if (cliente.getValue().getRegister().getUser().equals(userLogin)
                        && cliente.getValue().getRegister().getPassword().equals(passLogin)) {
                    this.clientesConectados.remove(cliente.getKey());
                    clienteActual.setRegister(cliente.getValue().getRegister());
                    String nuevoId = clienteActual.getId();
                    clienteActual.getRegister().setKey(nuevoId);
                    clienteActual.setConectado(true);
                    guardarEnUnJSON();
                    return true;
                }
            }
        }
        return false;
    }

}
