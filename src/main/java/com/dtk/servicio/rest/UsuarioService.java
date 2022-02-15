/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.dtk.servicio.rest;

import com.dtk.complementos.Alerta;
import static com.dtk.complementos.Global.SUCCESS;
import com.dtk.complementos.JWT;
import com.dtk.datos.UsuarioDaoImpl;
import com.dtk.dominio.Usuario;
import java.util.List;
import javax.json.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
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
@Path("Usuario")
public class UsuarioService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuarioService
     */
    public UsuarioService() {
    }
    
    //Metodo para login del usuario usando jwt
    @PUT
    @Path("/login")//
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Alerta loginUsuario(Usuario usuario) throws Exception {
        System.out.println(usuario.toString());
        usuario = new UsuarioDaoImpl().validarUsuario(usuario);
        Alerta alerta = new Alerta();
        if(usuario != null){
            JsonObject json =  JWT.generarJwt(usuario);
           
            alerta.setJwt(json);
            alerta.setTipo(SUCCESS);
            System.out.println("Alerta" + alerta.toString());
            return alerta;
        }
        else{
            alerta.setError(Response.Status.UNAUTHORIZED.toString());
            return alerta;
        }
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/user")
    public Usuario findUser(@QueryParam("idUsuario") int idTipoEmpleo) {
        String query = " WHERE idUsuario = " + idTipoEmpleo;
        Usuario usuario = new UsuarioDaoImpl().findUser(query);
        Response.ok();
        System.gc();
        return usuario;
    }
    
    
    @PUT
    @Path("/insertar")//hace referencia a /personas/{id}
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Alerta insertarUsuario(Usuario usuario) {
        System.out.print(usuario);
        System.out.print("Creando usuario ...");
        Alerta alerta = new UsuarioDaoImpl().insertarUsuario(usuario);
        Response.ok();
        System.gc();
        return alerta;
    }
}
