/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.dominio;

/**
 *
 * @author robinescobar
 */
public class OfertaPropuesta {
    private int idOfertaAplicada;
    private Oferta oferta;
    private String fechaAplicacion;
    private int estado;
    private Propuesta propuesta;

    public OfertaPropuesta(int idOfertaAplicada, Oferta oferta, String fechaAplicacion, int estado, Propuesta propuesta) {
        this.idOfertaAplicada = idOfertaAplicada;
        this.oferta = oferta;
        this.fechaAplicacion = fechaAplicacion;
        this.estado = estado;
        this.propuesta = propuesta;
    }

    public OfertaPropuesta() {
    }

    public OfertaPropuesta(Oferta oferta, String fechaAplicacion, int estado, Propuesta propuesta) {
        this.oferta = oferta;
        this.fechaAplicacion = fechaAplicacion;
        this.estado = estado;
        this.propuesta = propuesta;
    }

    public int getIdOfertaAplicada() {
        return idOfertaAplicada;
    }

    public void setIdOfertaAplicada(int idOfertaAplicada) {
        this.idOfertaAplicada = idOfertaAplicada;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public String getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(String fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Propuesta getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(Propuesta propuesta) {
        this.propuesta = propuesta;
    }

    @Override
    public String toString() {
        return "OfertaPropuesta{" + "idOfertaAplicada=" + idOfertaAplicada + ", oferta=" + oferta + ", fechaAplicacion=" + fechaAplicacion + ", estado=" + estado + ", propuesta=" + propuesta + '}';
    }
    
    
}
