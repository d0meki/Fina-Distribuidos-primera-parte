package Protocolos;

public class Login extends Object{

    private String user;
    private String password;
    private String key;
    public Login() {
        this.key = "";
        this.user = "";
        this.password = "";
    }

    public Login(String key,String user, String password) {
        this.key = key;
        this.user = user;
        this.password = password;
    }
    
 

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
