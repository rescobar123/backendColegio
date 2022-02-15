/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.dtk.servicio.rest;

import com.dtk.complementos.Alerta;
import com.dtk.datos.ComentarioDao;
import com.dtk.datos.OfertaDaoImpl;
import com.dtk.dominio.Comentario;
import com.dtk.dominio.Oferta;
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
@Path("ComentarioService")
public class ComentarioService {

    @Context
    private UriInfo context;

    public ComentarioService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/comentarios")
    public List<Comentario> getAllComentarios(@QueryParam("idPropuesta") int idPropuesta,
            @QueryParam("idOferta") int idOferta) throws InstantiationException, IllegalAccessException {
        String query = " AND idPropuesta = " + idPropuesta + " AND idOferta = " + idOferta;
        List<Comentario> comentarios = new ComentarioDao().findAllComentarios(query);
        Response.ok();
        System.gc();
        return comentarios;
    }
    
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/comentariosUser")
    public List<Comentario> getAllComentariosByIdUser(@QueryParam("idUsuario") int idUsuario) throws InstantiationException, IllegalAccessException {
        String query = " AND idUsuario = " + idUsuario;
        List<Comentario> comentarios = new ComentarioDao().findAllComentarios(query);
        Response.ok();
        System.gc();
        return comentarios;
    }
    
    @PUT
    @Path("/insertar")//hace referencia a /personas/{id}
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Alerta insertarComentario(Comentario comentario) throws InstantiationException, IllegalAccessException {
        Propuesta prop = new Propuesta();
        prop.setIdPropuesta(comentario.getIdComentario());//Algo raro para que funcione
        comentario.setProupesta(prop);
        comentario.setIdComentario(0);
        System.out.print("insertando comentario ...");
        //comentario.setRecibeEnvia(1); 
        Alerta alerta = new ComentarioDao().insertarComentario(comentario);
        Response.ok();
        System.gc();
        return alerta;
    }
}
