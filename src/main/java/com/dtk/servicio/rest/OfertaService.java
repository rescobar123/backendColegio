/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.dtk.servicio.rest;

import com.dtk.complementos.Alerta;
import com.dtk.datos.OfertaDaoImpl;
import com.dtk.datos.PropuestaDaoImpl;
import com.dtk.dominio.Oferta;
import com.dtk.dominio.Propuesta;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
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
@Path("OfertaService")
public class OfertaService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OfertaService
     */
    public OfertaService() {
    }

    @PUT
    @Path("/insertar")//hace referencia a /personas/{id}
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Alerta insertarOferta(Oferta oferta) {
        System.out.print(oferta);
        System.out.print("insertando oferta ...");
        Alerta alerta = new OfertaDaoImpl().insertarOferta(oferta);
        Response.ok();
        System.gc();
        return alerta;
    }
    
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ofertas")
    public List<Oferta> getPropuestaById(@QueryParam("idUsuarioCreo") int idUsuario) {
        String query = " AND prop.idUsuarioCreo = " + idUsuario;
        List<Oferta> ofertas = new OfertaDaoImpl().findAllOferas(query);
        Response.ok();
        System.gc();
        return ofertas;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ofertasByIdUsuarioOferta")
    public List<Oferta> getOfertasById(@QueryParam("idUsuarioCreo") int idUsuario) {
        String query = " AND ofer.idUsuarioCreoOferta = " + idUsuario;
        List<Oferta> ofertas = new OfertaDaoImpl().findAllOferas(query);
        Response.ok();
        System.gc();
        return ofertas;
    }
}
