/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.dominio;

/**
 *
 * @author robin.escobar
 */
public class Alumno {
    
    private int idAlumno;
    private CentroEducativo centroEducativo;
    private String codigoAlumno;
    private String nombres;
    private String apellidos;
    private String direccion;
    private int celular;
    private int estado;
    private String observacion;
    private String fechaCreacion;

    public Alumno() {
    }

    public Alumno(int idAlumno, CentroEducativo centroEducativo, String codigoAlumno, String nombres, String apellidos, String direccion, int celular, int estado, String observacion, String fechaCreacion) {
        this.idAlumno = idAlumno;
        this.centroEducativo = centroEducativo;
        this.codigoAlumno = codigoAlumno;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.celular = celular;
        this.estado = estado;
        this.observacion = observacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Alumno(CentroEducativo centroEducativo, String codigoAlumno, String nombres, String apellidos, String direccion, int celular, int estado, String observacion, String fechaCreacion) {
        this.centroEducativo = centroEducativo;
        this.codigoAlumno = codigoAlumno;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.celular = celular;
        this.estado = estado;
        this.observacion = observacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Alumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    
    
    
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public CentroEducativo getCentroEducativo() {
        return centroEducativo;
    }

    public void setCentroEducativo(CentroEducativo centroEducativo) {
        this.centroEducativo = centroEducativo;
    }

    public String getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", centroEducativo=" + centroEducativo + ", codigoAlumno=" + codigoAlumno + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", celular=" + celular + ", estado=" + estado + ", observacion=" + observacion + ", fechaCreacion=" + fechaCreacion + '}';
    }
    
    
}
