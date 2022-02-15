/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dtk.servicio.rest;

import com.dtk.complementos.JWT;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author admin
 */
@Provider
public class crosOrigin implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext response) {

        String url = requestContext.getUriInfo().getAbsolutePath().toString();
        response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type,X-Requested-With,accept,Origin,Access-Control-Allow-Origin,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization,Cookie");

        //Consultamos si esta yendo a consultar a login
        /*if(url.contains("/Usuario/login")){
              System.out.print("Que onda.....");
            return;
        }else{
            String token = requestContext.getHeaderString("Authorization");
            if(JWT.validadJwt(token)){
                response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
                response.getHeaders().putSingle("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
                response.getHeaders().putSingle("Access-Control-Allow-Headers","Content-Type,X-Requested-With,accept,Origin,Access-Control-Allow-Origin,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization,Cookie");
                
            }else{
                System.out.print("Token invalido");
                return;
            }
        }*/
    }
}
