/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.complementos;

import static com.dtk.complementos.Global.DATE_ACTUAL;
import static com.dtk.complementos.Global.KEY_JWT;
import com.dtk.dominio.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;


/**
 *
 * @author robinescobar
 */
public  class JWT {
    public static JsonObject generarJwt(Usuario usuario){
         String jwt = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, KEY_JWT)
                    .setSubject("Info. User")
                    .setIssuedAt(new Date(DATE_ACTUAL))
                    .setExpiration(new Date(DATE_ACTUAL+900000))//15 minutos expiracion
                    .claim("usuario", usuario)
                    .compact();
            JsonObject json = Json.createObjectBuilder()
                    .add("jwt", jwt).build();
            System.out.print(json);
        return json;
    }
    
    public static boolean validadJwt(String jwtString){
        System.out.print("token:: **");
        System.out.print(jwtString);
        System.out.print(" ** ::");
        return true;
    }
    
}
