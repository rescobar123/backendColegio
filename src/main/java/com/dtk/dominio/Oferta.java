/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.dominio;

/**
 *
 * @author robinescobar
 */
public class Oferta {
    private int idOferta;
    private Propuesta propuesta;
    private int precioPorHora;
    private String fechaInicio;
    private String fechaFin;
    private String horaInicio;
    private String horaFin;
    private String complemento;
    private String fechaCreacion;
    private int estado;
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Oferta(int idOferta, Propuesta propuesta, int precioPorHora, String fechaInicio, String fechaFin, String horaInicio, String horaFin, String complemento, String fechaCreacion, int estado, Usuario usuario) {
        this.idOferta = idOferta;
        this.propuesta = propuesta;
        this.precioPorHora = precioPorHora;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.complemento = complemento;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.usuario = usuario;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public Oferta(int idOferta, Propuesta propuesta, int precioPorHora, String fechaInicio, String fechaFin, String horaInicio, String horaFin, String complemento, String fechaCreacion, int estado) {
        this.idOferta = idOferta;
        this.propuesta = propuesta;
        this.precioPorHora = precioPorHora;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.complemento = complemento;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Oferta() {
    }

    public Oferta(Propuesta propuesta, int precioPorHora, String fechaInicio, String fechaFin, String horario, String complemento, String fechaCreacion, int estado) {
        this.propuesta = propuesta;
        this.precioPorHora = precioPorHora;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horaInicio = horario;
        this.complemento = complemento;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Oferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public Oferta(int idOferta, Propuesta propuesta, int precioPorHora, String fechaInicio, String fechaFin, String horario, String complemento, String fechaCreacion, int estado) {
        this.idOferta = idOferta;
        this.propuesta = propuesta;
        this.precioPorHora = precioPorHora;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horaInicio = horario;
        this.complemento = complemento;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

  

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public Propuesta getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(Propuesta propuesta) {
        this.propuesta = propuesta;
    }

    public int getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(int precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Oferta{" + "idOferta=" + idOferta + ", propuesta=" + propuesta + ", precioPorHora=" + precioPorHora + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", horario=" + horaInicio + '}';
    }
    
    
}
