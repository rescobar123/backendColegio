/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.dominio;

/**
 *
 * @author robin.escobar
 */
public class Curso {
    private int idCurso;
    private CentroEducativo centroEducativo;
    private String nombreCurso;
    private String nivel;

    public Curso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Curso(CentroEducativo centroEducativo, String nombreCurso, String nivel) {
        this.centroEducativo = centroEducativo;
        this.nombreCurso = nombreCurso;
        this.nivel = nivel;
    }

    public Curso(int idCurso, CentroEducativo centroEducativo, String nombreCurso, String nivel) {
        this.idCurso = idCurso;
        this.centroEducativo = centroEducativo;
        this.nombreCurso = nombreCurso;
        this.nivel = nivel;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public CentroEducativo getCentroEducativo() {
        return centroEducativo;
    }

    public void setCentroEducativo(CentroEducativo centroEducativo) {
        this.centroEducativo = centroEducativo;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Curso{" + "idCurso=" + idCurso + ", centroEducativo=" + centroEducativo + ", nombreCurso=" + nombreCurso + ", nivel=" + nivel + '}';
    }
    
    
}
