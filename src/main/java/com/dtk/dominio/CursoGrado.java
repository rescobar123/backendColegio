/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.dominio;

/**
 *
 * @author robin.escobar
 */
public class CursoGrado {
    private int idCurso;
    private String cursoPorComa;
    private Grado grado;
    private int anio;

    public CursoGrado(int idCurso) {
        this.idCurso = idCurso;
    }

    public CursoGrado(String cursoPorComa, Grado grado, int anio) {
        this.cursoPorComa = cursoPorComa;
        this.grado = grado;
        this.anio = anio;
    }

    public CursoGrado(int idCurso, String cursoPorComa, Grado grado, int anio) {
        this.idCurso = idCurso;
        this.cursoPorComa = cursoPorComa;
        this.grado = grado;
        this.anio = anio;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getCursoPorComa() {
        return cursoPorComa;
    }

    public void setCursoPorComa(String cursoPorComa) {
        this.cursoPorComa = cursoPorComa;
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
        return "CursoGrado{" + "idCurso=" + idCurso + ", cursoPorComa=" + cursoPorComa + ", grado=" + grado + ", anio=" + anio + '}';
    }
    
    
}
