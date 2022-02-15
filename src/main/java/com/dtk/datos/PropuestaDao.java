/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dtk.datos;

import com.dtk.complementos.Alerta;
import com.dtk.dominio.Propuesta;
import java.util.List;

/**
 *
 * @author robinescobar
 */
public interface PropuestaDao {
     public List<Propuesta> findAllPropuestas(String query);
     
     public List<Propuesta> findAllPropuestasWithUser(String query);
    
    public Propuesta findPropuestaById(Propuesta propuesta);
    
    public Alerta insertarPropuesta(Propuesta propuesta);
    
    public Alerta actualizarPropuesta(Propuesta propuesta);
    
    public Alerta deletePropuesta(Propuesta propuesta);
}
