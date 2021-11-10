/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.dtk.servicio.rest;

import com.dtk.datos.AlumnoDaoImpl;
import com.dtk.datos.PropietarioDAOimpl;
import com.dtk.dominio.Alumno;
import com.dtk.dominio.Propietario;
import com.dtk.dominio.Vehiculo;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author robin.escobar
 */
@Path("Alumno")
public class AlumnoService implements ContainerResponseFilter {

    @Context
    private UriInfo context;

    public AlumnoService() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listar")
    public List<Alumno> getAllAlumnos() {
         List<Alumno> alumnos = new AlumnoDaoImpl().findAllAlumnos();
        return alumnos;
    }
      @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext response) throws IOException {
        response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type");
    }
    
    
}
