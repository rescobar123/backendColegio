package com.dtk.dominio;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author robinescobar
 */
public class Comentario {
    private int idComentario;
    private int recibeEnvia;
    private String fechaHora;
    private String contenido;
    private int estado;
    private Propuesta proupesta;
    private Oferta oferta;

    public Comentario() {
    }

    public Comentario(int recibeEnvia, String contenido, int estado, Propuesta proupesta, Oferta oferta) {
        this.recibeEnvia = recibeEnvia;
        this.contenido = contenido;
        this.estado = estado;
        this.proupesta = proupesta;
        this.oferta = oferta;
    }
    
    public Comentario(int recibeEnvia, String fechaHora, String contenido, int estado, Propuesta proupesta, Oferta oferta) {
        this.recibeEnvia = recibeEnvia;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.estado = estado;
        this.proupesta = proupesta;
        this.oferta = oferta;
    }

    public Comentario(int idContenido, int recibeEnvia, String fechaHora, String contenido, int estado, Propuesta proupesta, Oferta oferta) {
        this.idComentario = idContenido;
        this.recibeEnvia = recibeEnvia;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.estado = estado;
        this.proupesta = proupesta;
        this.oferta = oferta;
    }

    public Propuesta getProupesta() {
        return proupesta;
    }

    public void setProupesta(Propuesta proupesta) {
        this.proupesta = proupesta;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    

    
    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idContenido) {
        this.idComentario = idContenido;
    }

    public int getRecibeEnvia() {
        return recibeEnvia;
    }

    public void setRecibeEnvia(int recibeEnvia) {
        this.recibeEnvia = recibeEnvia;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Comentario{" + "idComentario=" + idComentario + ", recibeEnvia=" + recibeEnvia + ", fechaHora=" + fechaHora + ", contenido=" + contenido + ", estado=" + estado + ", proupesta=" + proupesta + ", oferta=" + oferta + '}';
    }


    
    
}
