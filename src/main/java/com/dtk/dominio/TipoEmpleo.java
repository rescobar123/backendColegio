/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.dominio;

import com.dtk.datos.*;

/**
 *
 * @author robinescobar
 */
public class TipoEmpleo {
    private int idTipoEmpleo;
    private String nombreEmpleo;
    private String descripcion;

    public TipoEmpleo(String nombreEmpleo, String descripcion) {
        this.nombreEmpleo = nombreEmpleo;
        this.descripcion = descripcion;
    }

    public TipoEmpleo(int idTipoEmpleo) {
        this.idTipoEmpleo = idTipoEmpleo;
    }

    public TipoEmpleo() {
    }

    
    public TipoEmpleo(int idTipoEmpleo, String nombreEmpleo, String descripcion) {
        this.idTipoEmpleo = idTipoEmpleo;
        this.nombreEmpleo = nombreEmpleo;
        this.descripcion = descripcion;
    }

    public int getIdTipoEmpleo() {
        return idTipoEmpleo;
    }

    public void setIdTipoEmpleo(int idTipoEmpleo) {
        this.idTipoEmpleo = idTipoEmpleo;
    }

    public String getNombreEmpleo() {
        return nombreEmpleo;
    }

    public void setNombreEmpleo(String nombreEmpleo) {
        this.nombreEmpleo = nombreEmpleo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoEmpleo{" + "idTipoEmpleo=" + idTipoEmpleo + ", nombreEmpleo=" + nombreEmpleo + ", descripcion=" + descripcion + '}';
    }
    
    
}
