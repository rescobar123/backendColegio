
package com.dtk.dominio;

/**
 *
 * @author admin
 */
public class Propietario {
    private int id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String fechaNaci;
    private String direccion;
    private String telefono;
    private String email;
    private String estado;
    private String fechaCreacion;

    public Propietario(int id) {
         this.id = id;
    }
    
    public Propietario(){}

    public Propietario(int id, String nombre, String apellido, String identificacion, String fechaNaci, String direccion, String telefono, String email, String estado, String fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.fechaNaci = fechaNaci;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public Propietario(String nombre, String apellido, String identificacion, String fechaNaci, String direccion, String telefono, String email, String estado, String fechaCreacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.fechaNaci = fechaNaci;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public Propietario(String nombre, String apellido, String identificacion, String fechaNaci, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.fechaNaci = fechaNaci;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(String fechaNaci) {
        this.fechaNaci = fechaNaci;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Propietario{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", identificacion=" + identificacion + ", fechaNaci=" + fechaNaci + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", estado=" + estado + ", fechaCreacion=" + fechaCreacion + '}';
    }
    
    
    
    
}
