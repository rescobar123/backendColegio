package com.dtk.dominio;

/**
 *
 * @author admin
 */
public class Vehiculo {
    private int idVehiculo;
    private String placa;
    private String color;
    private String descripcion;
    private String marca;
    private String linea;
    private String cilindraje;
    private String chasis;
    private String tipo;
    private String modelo;
    private String fechaCreacion;
    private String estado;
    

    //constructor nulo
    public Vehiculo() {
    }

    public Vehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculo(String placa, String color, String descripcion, String marca, String linea, String cilindraje, String chasis, String tipo, String modelo, String fechaCreacion, String estado) {
        this.placa = placa;
        this.color = color;
        this.descripcion = descripcion;
        this.marca = marca;
        this.linea = linea;
        this.cilindraje = cilindraje;
        this.chasis = chasis;
        this.tipo = tipo;
        this.modelo = modelo;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Vehiculo(int idVehiculo, String placa, String color, String descripcion, String marca, String linea, String cilindraje, String chasis, String tipo, String modelo, String fechaCreacion, String estado) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.color = color;
        this.descripcion = descripcion;
        this.marca = marca;
        this.linea = linea;
        this.cilindraje = cilindraje;
        this.chasis = chasis;
        this.tipo = tipo;
        this.modelo = modelo;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Vehiculo(String placa, String color, String descripcion, String marca, String linea, String cilindraje, String chasis, String tipo, String modelo) {
        this.placa = placa;
        this.color = color;
        this.descripcion = descripcion;
        this.marca = marca;
        this.linea = linea;
        this.cilindraje = cilindraje;
        this.chasis = chasis;
        this.tipo = tipo;
        this.modelo = modelo;
    }

    public Vehiculo(int idVehiculo, String placa, String color, String descripcion, String marca, String linea, String cilindraje, String chasis, String tipo, String modelo) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.color = color;
        this.descripcion = descripcion;
        this.marca = marca;
        this.linea = linea;
        this.cilindraje = cilindraje;
        this.chasis = chasis;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
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
        return "Vehiculo{" + "idVehiculo=" + idVehiculo + ", placa=" + placa + ", color=" + color + ", descripcion=" + descripcion + ", marca=" + marca + ", linea=" + linea + ", cilindraje=" + cilindraje + ", chasis=" + chasis + ", tipo=" + tipo + ", modelo=" + modelo + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado + '}';
    }
    
    


    
    
}
