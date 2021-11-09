/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.dominio;

/**
 *
 * @author robin.escobar
 */
public class Actividad {
    private int idActividad;
    private CentroEducativo centroEducativo;
    private Grado grado;
    private Curso curso;
    private Docente docente;
    private String tituloTarea;
    private String fechaDeEntrega;
    private String documentoAdjunto;
    private String instrucciones;
    private double punteo;
    private String fechaCreacion;
    private String estado;

    public Actividad(int idActividad) {
        this.idActividad = idActividad;
    }

    
    public Actividad(CentroEducativo centroEducativo, Grado grado, Curso curso, Docente docente, String tituloTarea, String fechaDeEntrega, String documentoAdjunto, String instrucciones, double punteo, String fechaCreacion, String estado) {
        this.centroEducativo = centroEducativo;
        this.grado = grado;
        this.curso = curso;
        this.docente = docente;
        this.tituloTarea = tituloTarea;
        this.fechaDeEntrega = fechaDeEntrega;
        this.documentoAdjunto = documentoAdjunto;
        this.instrucciones = instrucciones;
        this.punteo = punteo;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    
    public Actividad(int idActividad, CentroEducativo centroEducativo, Grado grado, Curso curso, Docente docente, String tituloTarea, String fechaDeEntrega, String documentoAdjunto, String instrucciones, double punteo, String fechaCreacion, String estado) {
        this.idActividad = idActividad;
        this.centroEducativo = centroEducativo;
        this.grado = grado;
        this.curso = curso;
        this.docente = docente;
        this.tituloTarea = tituloTarea;
        this.fechaDeEntrega = fechaDeEntrega;
        this.documentoAdjunto = documentoAdjunto;
        this.instrucciones = instrucciones;
        this.punteo = punteo;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public CentroEducativo getCentroEducativo() {
        return centroEducativo;
    }

    public void setCentroEducativo(CentroEducativo centroEducativo) {
        this.centroEducativo = centroEducativo;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getTituloTarea() {
        return tituloTarea;
    }

    public void setTituloTarea(String tituloTarea) {
        this.tituloTarea = tituloTarea;
    }

    public String getFechaDeEntrega() {
        return fechaDeEntrega;
    }

    public void setFechaDeEntrega(String fechaDeEntrega) {
        this.fechaDeEntrega = fechaDeEntrega;
    }

    public String getDocumentoAdjunto() {
        return documentoAdjunto;
    }

    public void setDocumentoAdjunto(String documentoAdjunto) {
        this.documentoAdjunto = documentoAdjunto;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public double getPunteo() {
        return punteo;
    }

    public void setPunteo(double punteo) {
        this.punteo = punteo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Actividad{" + "idActividad=" + idActividad + ", centroEducativo=" + centroEducativo + ", grado=" + grado + ", curso=" + curso + ", docente=" + docente + ", tituloTarea=" + tituloTarea + ", fechaDeEntrega=" + fechaDeEntrega + ", documentoAdjunto=" + documentoAdjunto + ", instrucciones=" + instrucciones + ", punteo=" + punteo + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado + '}';
    }
    
    
    
}
