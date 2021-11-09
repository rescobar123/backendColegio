/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.dominio;

/**
 *
 * @author robin.escobar
 */
public class CentroEducativo {
    private int idCentroEducativo;
    private String nombre;
    private String ubicacion;
    private String fechaCreacion;
    private int cantidadAlumnos;
    private int pagoAlumno;
    private String responsable;
    private String telefonoResponable;

    public CentroEducativo(int idCentroEducativo) {
        this.idCentroEducativo = idCentroEducativo;
    }

    
    public CentroEducativo(String nombre, String ubicacion, String fechaCreacion, int cantidadAlumnos, int pagoAlumno, String responsable, String telefonoResponable) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.fechaCreacion = fechaCreacion;
        this.cantidadAlumnos = cantidadAlumnos;
        this.pagoAlumno = pagoAlumno;
        this.responsable = responsable;
        this.telefonoResponable = telefonoResponable;
    }

    
    public CentroEducativo(int idCentroEducativo, String nombre, String ubicacion, String fechaCreacion, int cantidadAlumnos, int pagoAlumno, String responsable, String telefonoResponable) {
        this.idCentroEducativo = idCentroEducativo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.fechaCreacion = fechaCreacion;
        this.cantidadAlumnos = cantidadAlumnos;
        this.pagoAlumno = pagoAlumno;
        this.responsable = responsable;
        this.telefonoResponable = telefonoResponable;
    }

    public int getIdCentroEducativo() {
        return idCentroEducativo;
    }

    public void setIdCentroEducativo(int idCentroEducativo) {
        this.idCentroEducativo = idCentroEducativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public int getPagoAlumno() {
        return pagoAlumno;
    }

    public void setPagoAlumno(int pagoAlumno) {
        this.pagoAlumno = pagoAlumno;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getTelefonoResponable() {
        return telefonoResponable;
    }

    public void setTelefonoResponable(String telefonoResponable) {
        this.telefonoResponable = telefonoResponable;
    }

    @Override
    public String toString() {
        return "CentroEducativo{" + "idCentroEducativo=" + idCentroEducativo + ", nombre=" + nombre + ", ubicacion=" + ubicacion + ", fechaCreacion=" + fechaCreacion + ", cantidadAlumnos=" + cantidadAlumnos + ", pagoAlumno=" + pagoAlumno + ", responsable=" + responsable + ", telefonoResponable=" + telefonoResponable + '}';
    }
    
    
}
