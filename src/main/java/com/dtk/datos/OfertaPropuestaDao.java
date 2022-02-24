/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.datos;

import static com.dtk.datos.PropuestaDaoImpl.SQL_SELECT;
import com.dtk.dominio.Oferta;
import com.dtk.dominio.OfertaPropuesta;
import com.dtk.dominio.Propuesta;
import com.dtk.dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author robinescobar
 */
public class OfertaPropuestaDao {

    public static final String SQL_SELECT = "SELECT oferProp.fechaAplicacion, oferProp.estado, us.nombres, us.apellidos,"
            + " prop.descripcion, us.foto, us.idUsuario, oferProp.idOferta, oferProp.idPropuesta"
            + " FROM ofertaPropuesta oferProp"
            + " JOIN oferta ofer ON oferProp.idOferta = ofer.idOferta"
            + " JOIN propuesta prop ON oferProp.idPropuesta = prop.idPropuesta"
            + " JOIN usuario us ON prop.idUsuarioCreo = us.idUsuario"
            + " WHERE 1 = 1 ";
    
    public List<OfertaPropuesta> findAllOfertasPropuestas(String query) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        OfertaPropuesta ofertaPropuesta = null;
        Propuesta propuesta = null;
        Oferta oferta = null;
        Usuario usuario = null;
        List<OfertaPropuesta> ofertaPropuestas = new ArrayList<>();
        try {
            try {
                conn = Conexion.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PropuestaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(PropuestaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(PropuestaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(SQL_SELECT + query);
            stmt = conn.prepareStatement(SQL_SELECT + query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int estado = rs.getInt("estado");
                String fechaAplicacion = rs.getString("fechaAplicacion");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String descripcion = rs.getString("descripcion");
                String foto = rs.getString("foto");
                int idOferta = rs.getInt("idOferta");
                int idPropuesta = rs.getInt("idPropuesta");
                int idUsuario = rs.getInt("idUsuario");
                usuario = new Usuario();
                usuario.setFoto(foto);
                usuario.setNombres(nombres);
                usuario.setApellidos(apellidos);
                usuario.setIdUsuario(idUsuario);
                
                propuesta = new Propuesta();
                propuesta.setIdPropuesta(idPropuesta);
                propuesta.setUsuarioCreo(usuario);
                propuesta.setDescripcion(descripcion);
                
                oferta = new Oferta();
                oferta.setIdOferta(idOferta);
                
                ofertaPropuesta =  new OfertaPropuesta();
                ofertaPropuesta.setFechaAplicacion(fechaAplicacion);
                ofertaPropuesta.setPropuesta(propuesta);
                ofertaPropuesta.setOferta(oferta);
                ofertaPropuesta.setEstado(estado);
                ofertaPropuestas.add(ofertaPropuesta);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return ofertaPropuestas;
    }
}
