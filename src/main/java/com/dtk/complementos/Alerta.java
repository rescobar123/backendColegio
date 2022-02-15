/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.complementos;

import javax.json.JsonObject;


/**
 *
 * @author robinescobar
 */
public class Alerta {
    private String tipo;
    private String Mensaje;
    private String error;
    private JsonObject jwt;

    public Alerta(String tipo, String Mensaje, String error) {
        this.tipo = tipo;
        this.Mensaje = Mensaje;
        this.error = error;
    }

    public Alerta(String tipo, String Mensaje, JsonObject jwt) {
        this.tipo = tipo;
        this.Mensaje = Mensaje;
        this.jwt = jwt;
    }

    public JsonObject getJwt() {
        return jwt;
    }

    public void setJwt(JsonObject jwt) {
        this.jwt = jwt;
    }



    public Alerta(String tipo, String Mensaje) {
        this.tipo = tipo;
        this.Mensaje = Mensaje;
    }

    public Alerta() {
       
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Alerta{" + "tipo=" + tipo + ", Mensaje=" + Mensaje + ", error=" + error + ", jwt=" + jwt + '}';
    }
    
    
}
