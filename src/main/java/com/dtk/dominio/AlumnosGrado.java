/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.dominio;

/**
 *
 * @author robin.escobar
 */
public class AlumnosGrado {
    private int id;
    private String alumnosPorComa;
    private Grado grado;
    private int anio;

    public AlumnosGrado(int id) {
        this.id = id;
    }

    
    public AlumnosGrado(String alumnosPorComa, Grado grado, int anio) {
        this.alumnosPorComa = alumnosPorComa;
        this.grado = grado;
        this.anio = anio;
    }

    
    public AlumnosGrado(int id, String alumnosPorComa, Grado grado, int anio) {
        this.id = id;
        this.alumnosPorComa = alumnosPorComa;
        this.grado = grado;
        this.anio = anio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlumnosPorComa() {
        return alumnosPorComa;
    }

    public void setAlumnosPorComa(String alumnosPorComa) {
        this.alumnosPorComa = alumnosPorComa;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "AlumnosGrado{" + "id=" + id + ", alumnosPorComa=" + alumnosPorComa + ", grado=" + grado + ", anio=" + anio + '}';
    }
    
    
}
