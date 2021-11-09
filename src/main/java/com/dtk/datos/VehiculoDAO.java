/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dtk.datos;

import com.dtk.dominio.Vehiculo;
import java.util.List;


/**
 *
 * @author admin
 */
public interface VehiculoDAO {
    public List<Vehiculo> findAllVehiculos();
    
    public Vehiculo findVehiculoById(Vehiculo vehiculo);
    
    public String insertVehiculo(Vehiculo vehiculo);
    
    public String updateVehiculo(Vehiculo vehiculo);
    
    public String deleteVehiculo(Vehiculo vehiculo);
}
