/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.datos;

import com.dtk.complementos.Alerta;
import static com.dtk.complementos.Global.AUTOINCREMENT;
import static com.dtk.complementos.Global.ERROR;
import static com.dtk.complementos.Global.SUCCESS;
import static com.dtk.datos.OfertaDaoImpl.SQL_SELECT;
import com.dtk.dominio.Comentario;
import com.dtk.dominio.Oferta;
import com.dtk.dominio.Propuesta;
import com.dtk.dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author robinescobar
 */
public class ComentarioDao {
    public static final String SQL_INSERT = "INSERT INTO comentario"
            + "(idContenido, recibeEnvia, fechaHora, contenido, estado, idPropuesta, idOferta)"
            + "VALUES (NULL, ?, NOW(), ?, ?, ?, ?)";
    public static final String SQL_INSERT_OFERTA = "INSERT INTO comentario"
            + "(idContenido, recibeEnvia, fechaHora, contenido, estado, idPropuesta, idOferta)"
            + "VALUES (NULL, ?, NOW(), ?, ?, ?, ( " +AUTOINCREMENT+ " ))";
    public static final String SQL_SELECT = "SELECT idContenido, recibeEnvia, fechaHora, contenido, "
            + "estado, idPropuesta, idOferta"
            + " FROM comentario " 
            +"  WHERE 1 = 1 ";
     public Alerta insertarComentario(Comentario comentario) throws InstantiationException, IllegalAccessException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Alerta alerta = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("ACA Comentario: " + comentario );
            if(comentario.getOferta().getIdOferta() == 0){
                System.out.print(SQL_INSERT_OFERTA + "Oferta 0");
                stmt = conn.prepareStatement(SQL_INSERT_OFERTA);
                stmt.setInt(1, comentario.getRecibeEnvia());
                stmt.setString(2, comentario.getContenido());
                stmt.setInt(3, comentario.getEstado());
                stmt.setInt(4, comentario.getProupesta().getIdPropuesta());
                 
            }else{
                System.out.print(SQL_INSERT);
                stmt = conn.prepareStatement(SQL_INSERT);
                stmt.setInt(1, comentario.getRecibeEnvia());
                stmt.setString(2, comentario.getContenido());
                stmt.setInt(3, comentario.getEstado());
                stmt.setInt(4, comentario.getProupesta().getIdPropuesta());
                stmt.setInt(5, comentario.getOferta().getIdOferta());
            }
            
           
            
            System.out.print("hola mundo ...");
            rows = stmt.executeUpdate();

            alerta = new Alerta(SUCCESS, "Mensaje Enviado exitosamente");

        } catch (SQLException ex) {
            alerta = new Alerta(ERROR, "Error al enviar msj" + ex.toString());
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PropuestaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            alerta = new Alerta(ERROR, "Error al enviar msj" + ex.toString());
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return alerta;
    }
     
     
      public List<Comentario> findAllComentarios(String query) throws InstantiationException, IllegalAccessException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Comentario comentario = null;
        Propuesta propuesta;
        Oferta oferta;
        List<Comentario> comentarios = new ArrayList<>();
        try {
            try {
                conn = Conexion.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PropuestaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(SQL_SELECT + query);
            stmt = conn.prepareStatement(SQL_SELECT + query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idContenido = rs.getInt("idContenido");
                int recibaEnvia = rs.getInt("recibeEnvia");
                String fechaHora = rs.getString("fechaHora");
                String contenido = rs.getString("contenido");
                int estado = rs.getInt("estado");
                propuesta  = new Propuesta(rs.getInt("idPropuesta"));
                oferta = new Oferta(rs.getInt("idOferta"));
                comentario = new Comentario(idContenido, recibaEnvia, fechaHora, contenido, estado, propuesta, oferta);
                comentarios.add(comentario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return ofertas;
        return comentarios;
    }
     
     

}
