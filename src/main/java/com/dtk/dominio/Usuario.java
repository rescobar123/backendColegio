/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.dominio;

/**
 *
 * @author robinescobar
 */
public class Usuario {

    private int idUsuario;
    private String password;
    private String rol;
    private String fechaCreacion;
    private String nombres;
    private String email;
    private String apellidos;
    private String direccion;
    private String fechaNacimiento;
    private String educacion;
    private String genero;
    private String vacunaCovid;
    private String cv;
    private String foto;

    public Usuario() {
    }

    public Usuario(String password, String rol, String fechaCreacion, String nombres, String email, String apellidos, String direccion, String fechaNacimiento, String educacion, String genero, String vacunaCovid, String cv, String foto) {
        this.password = password;
        this.rol = rol;
        this.fechaCreacion = fechaCreacion;
        this.nombres = nombres;
        this.email = email;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.educacion = educacion;
        this.genero = genero;
        this.vacunaCovid = vacunaCovid;
        this.cv = cv;
        this.foto = foto;
    }
    
    

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    

    public Usuario(int idUsuario, String password, String rol, String fechaCreacion, String nombres, String email, String apellidos, String direccion, String fechaNacimiento, String educacion, String genero, String vacunaCovid, String cv, String foto) {
        this.idUsuario = idUsuario;
        this.password = password;
        this.rol = rol;
        this.fechaCreacion = fechaCreacion;
        this.nombres = nombres;
        this.email = email;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.educacion = educacion;
        this.genero = genero;
        this.vacunaCovid = vacunaCovid;
        this.cv = cv;
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", password=" + password + ", rol=" + rol + ", fechaCreacion=" + fechaCreacion + ", nombres=" + nombres + ", email=" + email + ", apellidos=" + apellidos + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento + ", educacion=" + educacion + ", genero=" + genero + ", vacunaCovid=" + vacunaCovid + ", cv=" + cv + '}';
    }
    
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEducacion() {
        return educacion;
    }

    public void setEducacion(String educacion) {
        this.educacion = educacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getVacunaCovid() {
        return vacunaCovid;
    }

    public void setVacunaCovid(String vacunaCovid) {
        this.vacunaCovid = vacunaCovid;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

   

}
