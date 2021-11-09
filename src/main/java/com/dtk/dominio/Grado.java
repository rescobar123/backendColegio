/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.dominio;

/**
 *
 * @author robin.escobar
 */
public class Grado {
    private int idGrado;
    private CentroEducativo centroEducativo;
    private String nombre;
    private String nivel;

    public Grado(int idGrado) {
        this.idGrado = idGrado;
    }

    
    public Grado(CentroEducativo centroEducativo, String nombre, String nivel) {
        this.centroEducativo = centroEducativo;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    
    public Grado(int idGrado, CentroEducativo centroEducativo, String nombre, String nivel) {
        this.idGrado = idGrado;
        this.centroEducativo = centroEducativo;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    public CentroEducativo getCentroEducativo() {
        return centroEducativo;
    }

    public void setCentroEducativo(CentroEducativo centroEducativo) {
        this.centroEducativo = centroEducativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Grado{" + "idGrado=" + idGrado + ", centroEducativo=" + centroEducativo + ", nombre=" + nombre + ", nivel=" + nivel + '}';
    }
    
    
}
