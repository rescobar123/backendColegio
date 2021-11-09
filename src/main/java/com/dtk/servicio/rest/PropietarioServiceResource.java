/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dtk.servicio.rest;

import com.dtk.datos.PropietarioDAOimpl;
import com.dtk.dominio.Propietario;
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
@Path("PropietarioService")
public class PropietarioServiceResource implements ContainerResponseFilter {

    @Context
    private UriInfo context;
    
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext response) {
        response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type");
    }

    /**
     * Creates a new instance of PropietarioServiceResource
     */
    public PropietarioServiceResource() {
    }

   @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Propietario> getAllPropietarios() {
         List<Propietario> propietarios = new PropietarioDAOimpl().findAllPropietarios();
        return propietarios;
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/desasociar/{idVehiculo}/{idPersona}")
    public Vehiculo insertarVehiculoPropietario(@PathParam("idVehiculo") int idVehiculo, @PathParam("idPersona") int idPersona) {
        Propietario propietario = new Propietario(idPersona);
        Vehiculo vehi = new Vehiculo(idVehiculo);
        String respuesta = new PropietarioDAOimpl().desasociarVehiculoPropietario(propietario, vehi);
        Response.ok(respuesta);
        vehi.setDescripcion(respuesta);
        return vehi;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{idVehiculo}/{idPersona}")
    public Vehiculo desasociarVehiculo(@PathParam("idVehiculo") int idVehiculo, @PathParam("idPersona") int idPersona) {
        Propietario propietario = new Propietario(idPersona);
        Vehiculo vehi = new Vehiculo(idVehiculo);
        String respuesta = new PropietarioDAOimpl().insertVehiculoPropiead(propietario, vehi);
        Response.ok(respuesta);
        vehi.setDescripcion(respuesta);
        return vehi;
    }
    
    
}
