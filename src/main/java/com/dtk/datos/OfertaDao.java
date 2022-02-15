/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dtk.datos;

import com.dtk.complementos.Alerta;
import com.dtk.dominio.Oferta;
import java.util.List;

/**
 *
 * @author robinescobar
 */
public interface OfertaDao {
    public List<Oferta> findAllOferas(String query);
    
    public Oferta findOfertaById(Oferta oferta);
    
    public Alerta insertarOferta(Oferta oferta);
    
    public Alerta actualizarOferta(Oferta oferta);
    
    public Alerta deleteOferta(Oferta oferta);
}
