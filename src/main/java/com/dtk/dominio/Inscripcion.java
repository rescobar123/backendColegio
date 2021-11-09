/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.dominio;

/**
 *
 * @author robin.escobar
 */
public class Inscripcion {
    private int idInscripcion;
    private CentroEducativo centroEducativo;
    private Alumno alumno;
    private Grado grado;
    private int anioEscolar;

    public Inscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    
    public Inscripcion(CentroEducativo centroEducativo, Alumno alumno, Grado grado, int anioEscolar) {
        this.centroEducativo = centroEducativo;
        this.alumno = alumno;
        this.grado = grado;
        this.anioEscolar = anioEscolar;
    }

    
    public Inscripcion(int idInscripcion, CentroEducativo centroEducativo, Alumno alumno, Grado grado, int anioEscolar) {
        this.idInscripcion = idInscripcion;
        this.centroEducativo = centroEducativo;
        this.alumno = alumno;
        this.grado = grado;
        this.anioEscolar = anioEscolar;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public CentroEducativo getCentroEducativo() {
        return centroEducativo;
    }

    public void setCentroEducativo(CentroEducativo centroEducativo) {
        this.centroEducativo = centroEducativo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public int getAnioEscolar() {
        return anioEscolar;
    }

    public void setAnioEscolar(int anioEscolar) {
        this.anioEscolar = anioEscolar;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripcion=" + idInscripcion + ", centroEducativo=" + centroEducativo + ", alumno=" + alumno + ", grado=" + grado + ", anioEscolar=" + anioEscolar + '}';
    }
            
    
}
