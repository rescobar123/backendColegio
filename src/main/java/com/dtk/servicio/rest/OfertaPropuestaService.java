/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.dtk.servicio.rest;

import com.dtk.datos.OfertaDaoImpl;
import com.dtk.datos.OfertaPropuestaDao;
import com.dtk.dominio.Oferta;
import com.dtk.dominio.OfertaPropuesta;
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
@Path("ofertaPropuestaService")
public class OfertaPropuestaService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OfertaPropuestaService
     */
    public OfertaPropuestaService() {
    }

        @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/propuestasByOfer")
    public List<OfertaPropuesta> getOfertas(@QueryParam("idOferta") int idOferta) {
        String query = " AND oferProp.idOferta = " + idOferta;
        List<OfertaPropuesta> ofertaPropuestas = new OfertaPropuestaDao().findAllOfertasPropuestas(query);
        Response.ok();
        System.gc();
        return ofertaPropuestas;
    }

}
