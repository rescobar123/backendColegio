/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.dominio;

/**
 *
 * @author robinescobar
 */
public class Propuesta {
    private int idPropuesta;
    private int idTipoPropuesta;
    private String diasLaborables;
    private String disponibilidad;
    private String precioPorHora;
    private String lugaresLaborables;
    private String descripcion;
    private String fechaPropuesta;
    private int estado;
    private String certificado;
    private Usuario usuarioCreo;
 

    public Propuesta(int idPropuesta, int idTipoPropuesta, String diasLaborables, String disponibilidad, String precioPorHora, String lugaresLaborables, String descripcion, String fechaPropuesta, int estado, String certificado, Usuario usuarioCreo) {
        this.idPropuesta = idPropuesta;
        this.idTipoPropuesta = idTipoPropuesta;
        this.diasLaborables = diasLaborables;
        this.disponibilidad = disponibilidad;
        this.precioPorHora = precioPorHora;
        this.lugaresLaborables = lugaresLaborables;
        this.descripcion = descripcion;
        this.fechaPropuesta = fechaPropuesta;
        this.estado = estado;
        this.certificado = certificado;
        this.usuarioCreo = usuarioCreo;
    }

    public Usuario getUsuarioCreo() {
        return usuarioCreo;
    }

    public void setUsuarioCreo(Usuario usuarioCreo) {
        this.usuarioCreo = usuarioCreo;
    }

    public Propuesta(int idPropuesta) {
        this.idPropuesta = idPropuesta;
    }

    public Propuesta() {
    }

    
    public Propuesta(int idPropuesta, int idTipoPropuesta, String diasLaborables, String disponibilidad, String precioPorHora, String lugaresLaborables, String descripcion, String fechaPropuesta, int estado, String certificado) {
        this.idPropuesta = idPropuesta;
        this.idTipoPropuesta = idTipoPropuesta;
        this.diasLaborables = diasLaborables;
        this.disponibilidad = disponibilidad;
        this.precioPorHora = precioPorHora;
        this.lugaresLaborables = lugaresLaborables;
        this.descripcion = descripcion;
        this.fechaPropuesta = fechaPropuesta;
        this.estado = estado;
        this.certificado = certificado;
    }

    public Propuesta(int idTipoPropuesta, String diasLaborables, String disponibilidad, String precioPorHora, String lugaresLaborables, String descripcion, String fechaPropuesta, int estado, String certificado) {
        this.idTipoPropuesta = idTipoPropuesta;
        this.diasLaborables = diasLaborables;
        this.disponibilidad = disponibilidad;
        this.precioPorHora = precioPorHora;
        this.lugaresLaborables = lugaresLaborables;
        this.descripcion = descripcion;
        this.fechaPropuesta = fechaPropuesta;
        this.estado = estado;
        this.certificado = certificado;
    }
    
    

    @Override
    public String toString() {
        return "Propuesta{" + "idPropuesta=" + idPropuesta + ", idTipoPropuesta=" + idTipoPropuesta + ", diasLaborables=" + diasLaborables + ", disponibilidad=" + disponibilidad + ", precioPorHora=" + precioPorHora + ", lugaresLaborables=" + lugaresLaborables + ", descripcion=" + descripcion + ", fechaPropuesta=" + fechaPropuesta + ", estado=" + estado + ", certificado=" + certificado + '}';
    }

    public int getIdPropuesta() {
        return idPropuesta;
    }

    public void setIdPropuesta(int idPropuesta) {
        this.idPropuesta = idPropuesta;
    }

    public int getIdTipoPropuesta() {
        return idTipoPropuesta;
    }

    public void setIdTipoPropuesta(int idTipoPropuesta) {
        this.idTipoPropuesta = idTipoPropuesta;
    }

    public String getDiasLaborables() {
        return diasLaborables;
    }

    public void setDiasLaborables(String diasLaborables) {
        this.diasLaborables = diasLaborables;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(String precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

    public String getLugaresLaborables() {
        return lugaresLaborables;
    }

    public void setLugaresLaborables(String lugaresLaborables) {
        this.lugaresLaborables = lugaresLaborables;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaPropuesta() {
        return fechaPropuesta;
    }

    public void setFechaPropuesta(String fechaPropuesta) {
        this.fechaPropuesta = fechaPropuesta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }
    
    
}
