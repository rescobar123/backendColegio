/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dtk.dominio;

/**
 *
 * @author admin
 */
public class Propiedades {
    private Propietario propietario;
    private Vehiculo vehiculo;
    
    private int idVehiculo;
    private String placa;
    private String color;
    private String marca;
    private String linea;
    private String tipo;
    private String modelo;
    

    public Propiedades() {
    }

    public Propiedades(Propietario propietario, Vehiculo vehiculo) {
        this.propietario = propietario;
        this.vehiculo = vehiculo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Propiedades(int idVehiculo, String placa, String color, String marca, String linea, String tipo, String modelo) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.color = color;
        this.marca = marca;
        this.linea = linea;
        this.tipo = tipo;
        this.modelo = modelo;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    
    
    
}
