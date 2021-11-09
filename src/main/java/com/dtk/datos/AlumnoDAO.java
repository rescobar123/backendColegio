/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dtk.datos;

import com.dtk.dominio.Alumno;
import java.util.List;

/**
 *
 * @author robin.escobar
 */
public interface AlumnoDAO {
     public List<Alumno> findAllAlumnos();
    
    public Alumno findAlumnoById(Alumno vehiculo);
    
    public String insertAlumno(Alumno vehiculo);
    
    public String updateAlumno(Alumno vehiculo);
    
    public String deleteAlumno(Alumno vehiculo);
}
