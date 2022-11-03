package Cliente;
import Objetos.SuperClase;
import Protocolos.AsigId;
import Protocolos.Login;
import Protocolos.Matriz;
import Protocolos.Register;
import Protocolos.Start;
import Protocolos.Winner;
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente{
    private int PUERTO;
    private String HostName;
    private EscuchadorDataCliente escuchadorDeData;
    private Socket socket;

    public Cliente(int PUERTO, String HostName) {
        this.PUERTO = PUERTO;
        this.HostName = HostName;
    }
    public void conectarCliente(DataListenner obj) throws IOException{
         this.socket = new Socket(this.HostName,this.PUERTO);
         this.escuchadorDeData = new EscuchadorDataCliente(this.socket);
         this.escuchadorDeData.addEventDataListener(obj);
         this.escuchadorDeData.start();
    }
    public void Login(Login login){
        SuperClase sc = new SuperClase("Login",login);
        TareaCliente t = new TareaCliente(sc,this.socket);
        t.run();
    }
    public void Register(Register register){
        SuperClase sc = new SuperClase("Register",register); 
        TareaCliente t = new TareaCliente(sc,this.socket);
        t.run();
    }
    public void enviarTabla(Matriz m){
        SuperClase sc = new SuperClase("Matriz",m); 
        TareaCliente t = new TareaCliente(sc,this.socket);
        t.run();
    }
    public void empezarJuego(Start s){
        SuperClase sc = new SuperClase("Juego",s); 
        TareaCliente t = new TareaCliente(sc,this.socket);
        t.run();
    }
    public void ganador(Winner w){
        SuperClase sc = new SuperClase("Ganador",w); 
        TareaCliente t = new TareaCliente(sc,this.socket);
        t.run();
    }
    
//    @Override
//    public void OnRead(MyEventoDataCliente evt) {
//       // TareaSwitchCliente tsc = new TareaSwitchCliente(evt);
//       Gson gson = new Gson();
//        SuperClase sc = gson.fromJson(evt.getMensaje(), SuperClase.class);
//        String json = gson.toJson(sc.getClase());
//        switch (sc.getIdentificador()) {
//            case "Id":
//                //almacenar ese ID para que persista mientra exista la conexion
//                 AsigId aid = gson.fromJson(json, AsigId.class);
//                 this.id = aid.getId();
//                 System.out.println("Me conecte y recibí este id: " + this.id);
//                break;
//            case "Notificacion":
//                //mostrar notificacion
//
//                break;
//            default:
//                System.out.println("default");
//
//        }
//    }
    
    
    
    public int getPUERTO() {
        return PUERTO;
    }

    public void setPUERTO(int PUERTO) {
        this.PUERTO = PUERTO;
    }

    public String getHostName() {
        return HostName;
    }

    public void setHostName(String HostName) {
        this.HostName = HostName;
    }

  
    
    
    
}
