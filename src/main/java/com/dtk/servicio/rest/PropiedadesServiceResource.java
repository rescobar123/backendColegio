/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dtk.servicio.rest;

import com.dtk.datos.PropiedadesDAO;
import com.dtk.dominio.Propiedades;
import com.dtk.dominio.Propietario;
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

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("PropiedadesService")
public class PropiedadesServiceResource implements ContainerResponseFilter{

    @Context
    private UriInfo context;
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext response) {
        response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type");
    }

    public PropiedadesServiceResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Propiedades> getPropiedades() {
         List<Propiedades> propiedades = new PropiedadesDAO().findAllPropiedades(0);
        return propiedades;
    }
    
    @GET
    @Produces( MediaType.APPLICATION_JSON)
    @Path("{id}")//hace referencia a /propiedades/{id}
    public List<Propiedades> vehiculosDePropietario(@PathParam("id") int id) {
        List<Propiedades> propiedades = new PropiedadesDAO().getPropieadesPersona(id);
        return propiedades;
    }

    /**
     * PUT method for updating or creating an instance of PropiedadesServiceResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
