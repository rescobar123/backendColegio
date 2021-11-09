/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.dominio;

/**
 *
 * @author robin.escobar
 */
public class Docente {
    private int idDocente;
    private CentroEducativo centroEducativo;
    private String nombreCompleto;
    private String direccion;
    private int telefono;
    private String escolaridad;

    public Docente(int idDocente) {
        this.idDocente = idDocente;
    }

    
    public Docente(CentroEducativo centroEducativo, String nombreCompleto, String direccion, int telefono, String escolaridad) {
        this.centroEducativo = centroEducativo;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.escolaridad = escolaridad;
    }

    
    public Docente(int idDocente, CentroEducativo centroEducativo, String nombreCompleto, String direccion, int telefono, String escolaridad) {
        this.idDocente = idDocente;
        this.centroEducativo = centroEducativo;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.escolaridad = escolaridad;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public CentroEducativo getCentroEducativo() {
        return centroEducativo;
    }

    public void setCentroEducativo(CentroEducativo centroEducativo) {
        this.centroEducativo = centroEducativo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    @Override
    public String toString() {
        return "Docente{" + "idDocente=" + idDocente + ", centroEducativo=" + centroEducativo + ", nombreCompleto=" + nombreCompleto + ", direccion=" + direccion + ", telefono=" + telefono + ", escolaridad=" + escolaridad + '}';
    }
    
    
}
