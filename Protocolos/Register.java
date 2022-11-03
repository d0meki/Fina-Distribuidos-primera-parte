/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Protocolos;

import java.io.Serializable;

/**
 *
 * @author USUARIO
 */
public class Register extends Object implements Serializable{
    private String key;
    private String Nombre;
    private String correo;
    private String user;
    private String password;
    private String telefono;
    public Register(){
        this.Nombre = "";
        this.correo = "";
        this.user = "";
        this.password="";
        this.telefono = "";
        this.key = "";
    }
    public Register(String key,
                    String Nombre, 
                    String correo, 
                    String user, 
                    String password, 
                    String telefono
                    ) {
        this.key = key;
        this.Nombre = Nombre;
        this.correo = correo;
        this.user = user;
        this.password = password;
        this.telefono = telefono;
    }
       public boolean registrado() {
        return !"".equals(this.user) && !"".equals(this.password);
    }
    public boolean noRegistrado(){
        return this.user == "" || this.password == "";
    }
    public boolean validarLogin(String user, String passwd){
        return (user.equals(this.user) && passwd.equals(this.password));
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    
}
