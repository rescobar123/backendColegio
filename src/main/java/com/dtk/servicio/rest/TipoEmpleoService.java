/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.dtk.servicio.rest;

import com.dtk.datos.TipoEmpleoDao;
import com.dtk.dominio.TipoEmpleo;
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
@Path("tipoEmpleo")
public class TipoEmpleoService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TipoEmpleoService
     */
    public TipoEmpleoService() {
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tipoEmpleo")
    public List<TipoEmpleo> getTipoEmpleoById(@QueryParam("idTipoEmpleo") int idTipoEmpleo) throws InstantiationException, IllegalAccessException {
        String query = " AND idTipoEmpleo = " + idTipoEmpleo;
        List<TipoEmpleo> tipoEmpleos = new TipoEmpleoDao().findAllEmpleos(query);
        Response.ok();
        System.gc();
        return tipoEmpleos;
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listar")
    public List<TipoEmpleo> getAllTipoEmpleo() throws InstantiationException, IllegalAccessException {
        String query = "";
        List<TipoEmpleo> tipoEmpleos = new TipoEmpleoDao().findAllEmpleos(query);
        Response.ok();
        System.gc();
        return tipoEmpleos;
    }
    


}
