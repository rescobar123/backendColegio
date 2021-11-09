/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dtk.servicio.rest;

import com.dtk.datos.VehiculoDAOimpl;
import com.dtk.dominio.Vehiculo;
import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * REST Web Service
 *
 * @author admin
 */
@Path("Vehiculo")
public class VehiculoResource implements ContainerResponseFilter {
    Vehiculo vehi;
    @Context
    private UriInfo context;
    
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext response) {
        response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type");
    }
    public VehiculoResource() {
        
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /personas/{id}
    public Vehiculo vehiculoById(@PathParam("id") int id) {
        Vehiculo vehiculo = new Vehiculo(id);
        Vehiculo vehi = new VehiculoDAOimpl().findVehiculoById(vehiculo);
        Response.ok(vehi);
        return vehi;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listar")//hace referencia a /personas/{id}
    public List<Vehiculo> getvehiculos() {
         List<Vehiculo> vehiculos = new VehiculoDAOimpl().findAllVehiculos();
         Response.ok(vehiculos);
        return vehiculos;
    }

    @PUT
    @Path("/insertar")//hace referencia a /personas/{id}
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Vehiculo agregarVehiculo(Vehiculo vehi) {
        String impl = new VehiculoDAOimpl().insertVehiculo(vehi);
        Vehiculo vehilo = new Vehiculo(vehi.getIdVehiculo());
        vehilo.setDescripcion(impl);
        Response.ok();
        return vehilo;
    }  
    
    @PUT
    @Path("/actualizar")//hace referencia a /personas/{id}
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Vehiculo upVehiculo(Vehiculo vehi){
        String impl = new VehiculoDAOimpl().updateVehiculo(vehi);
        Vehiculo vehilo = new Vehiculo(vehi.getIdVehiculo());
        vehilo.setDescripcion(impl);
        Response.ok();
        return vehilo;
    }
    
    @PUT
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Vehiculo delVehiculo(Vehiculo vehi){
        String impl = new VehiculoDAOimpl().deleteVehiculo(vehi);
        Vehiculo vehilo = new Vehiculo(vehi.getIdVehiculo());
        vehilo.setDescripcion(impl);
        Response.ok();
        return vehilo;
    }
  
}
