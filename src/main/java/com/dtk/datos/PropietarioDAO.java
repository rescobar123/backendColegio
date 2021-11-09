/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dtk.datos;


import com.dtk.dominio.Propietario;
import java.util.List;

/**
 *
 * @author admin
 */
public interface PropietarioDAO {
    public List<Propietario> findAllPropietarios();
    public Propietario finfPropietarioById(Propietario propietario);
}
