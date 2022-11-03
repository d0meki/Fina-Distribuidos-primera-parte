/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Protocolos;

import java.io.Serializable;

/**
 *
 * @author domek
 */
public class Usuario extends Object implements Serializable{
    private String usuario;
    private boolean conectado;

    public Usuario(String usuario, boolean conectado) {
        this.usuario = usuario;
        this.conectado = conectado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
    
}
