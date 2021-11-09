/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dtk.servicio.rest;

import java.util.Set;

import javax.ws.rs.core.Application;

/**
 *
 * @author admin
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application   {
    

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

  
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.dtk.servicio.rest.PropiedadesServiceResource.class);
        resources.add(com.dtk.servicio.rest.PropietarioServiceResource.class);
        resources.add(com.dtk.servicio.rest.VehiculoResource.class);
        resources.add(com.dtk.servicio.rest.crosOrigin.class);
    }
    
}
