/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.Serializable;

/**
 *
 * @author USUARIO
 */
public class SuperClase <T> implements Serializable{
    private String identificador;
    private T clase;

    public SuperClase() {
       this.identificador = "";
       this.clase = null;
    }
    public SuperClase(String identificador, T clase) {
        this.identificador = identificador;
        this.clase = clase;
    }
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public T getClase() {
        return clase;
    }

    public void setClase(T clase) {
        this.clase = clase;
    }
    
}
