/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.dtk.servicio.rest;

import com.dtk.complementos.Alerta;
import com.dtk.datos.PropuestaDaoImpl;
import com.dtk.dominio.Propuesta;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author robinescobar
 */
@Path("propuesta")
public class PropuestaService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PropuestaService
     */
    public PropuestaService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listar")
    public List<Propuesta> getAllPropuestas() {
        String query = "";
        List<Propuesta> propuestas = new PropuestaDaoImpl().findAllPropuestas(query);
        Response.ok();
        System.gc();
        return propuestas;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/propCreadas")
    public List<Propuesta> getAllPropuestasWithUserTipoEmpleo(@QueryParam("idPropuesta") int idPropuesta, @QueryParam("idUsuario") int idUsuario) {
        String query = "";
        if (idPropuesta == 0) {
            query += "";
        } else {
            query += " AND idPropuesta = " + idPropuesta;
        }

        if (idUsuario == 0) {
            query += "";
        } else {
            query += " AND idUsuario = " + idUsuario;
        }

        List<Propuesta> propuestas = new PropuestaDaoImpl().findAllPropuestasWithUser(query);
        Response.ok();
        System.gc();
        return propuestas;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/propById")
    public List<Propuesta> getPropuestaById(@QueryParam("idPropuesta") int idPropuesta) {
        String query = " AND idPropuesta = " + idPropuesta;
        List<Propuesta> propuestas = new PropuestaDaoImpl().findAllPropuestas(query);
        Response.ok();
        System.gc();
        return propuestas;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listarUsuario")
    public List<Propuesta> getAllPropuestasByIdUser(@QueryParam("idUser") String idUser) {
        String query = " AND idUsuarioCreo  = " + idUser;
        List<Propuesta> propuestas = new PropuestaDaoImpl().findAllPropuestas(query);
        Response.ok();
        System.gc();
        return propuestas;
    }

    @PUT
    @Path("/insertar")//hace referencia a /personas/{id}
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Alerta insertarPropuesta(Propuesta propuesta) {
        System.out.print(propuesta);
        System.out.print("publicando propuesta ...");
        Alerta alerta = new PropuestaDaoImpl().insertarPropuesta(propuesta);
        Response.ok();
        System.gc();
        return alerta;
    }

    @PUT
    @Path("/delete")//hace referencia a /personas/{id}
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Alerta eliminarPropuesta(Propuesta propuesta) {
        System.out.print(propuesta);
        System.out.print("eliminando propuesta ...");
        Alerta alerta = new PropuestaDaoImpl().deletePropuesta(propuesta);
        Response.ok();
        System.gc();
        return alerta;
    }

    @PUT
    @Path("/actualizar")//hace referencia a /personas/{id}
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Alerta actualizarPropuesta(Propuesta propuesta) {
        System.out.print(propuesta);
        System.out.print("actualizando propuesta ...");
        Alerta alerta = new PropuestaDaoImpl().actualizarPropuesta(propuesta);
        Response.ok();
        System.gc();
        return alerta;
    }
}
