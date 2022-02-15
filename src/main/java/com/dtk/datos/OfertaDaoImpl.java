/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.datos;

import com.dtk.complementos.Alerta;
import static com.dtk.complementos.Global.AUTOINCREMENT;
import static com.dtk.complementos.Global.ERROR;
import static com.dtk.complementos.Global.SUCCESS;
import static com.dtk.datos.PropuestaDaoImpl.SQL_SELECT;
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
public class OfertaDaoImpl implements OfertaDao {
    
    public static final String SQL_INSERT = "INSERT INTO oferta"
            + "(idOferta, idPropuesta, precioPorHora, fechaInicio, fechaFin, "
            + "horaInicio, horaFin, complemento, fechaCreacion, estado, idUsuarioCreoOferta) VALUES "
            + "(NULL, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, ?);";
    
    public static final String SQL_SELECT = "SELECT ofer.idOferta, ofer.idPropuesta, ofer.precioPorHora, "
            + " ofer.fechaInicio, ofer.fechaFin,ofer.horaInicio, ofer.horaFin, ofer.complemento, "
            + " ofer.fechaCreacion, ofer.estado, tip.nombreEmpleo, user.nombres, user.apellidos, user.idUsuario "
            + " FROM oferta ofer "
            + " JOIN propuesta prop ON ofer.idPropuesta = prop.idPropuesta "
            + " JOIN tipoEmpleo tip ON prop.idTipoPropuesta = tip.idTipoEmpleo " 
            + " JOIN usuario user ON ofer.idUsuarioCreoOferta = user.idUsuario " 
            +"  WHERE 1 = 1 ";

    @Override
    public List<Oferta> findAllOferas(String query) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Oferta oferta = null;
        Propuesta propuesta = null;
        Usuario usuario = null;
        List<Oferta> ofertas = new ArrayList<>();
        try {
            try {
                conn = Conexion.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PropuestaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(OfertaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(OfertaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(SQL_SELECT + query);
            stmt = conn.prepareStatement(SQL_SELECT + query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idOferta = rs.getInt("idOferta");
                int idPropuesta = rs.getInt("idPropuesta");
                int precioPorHora = rs.getInt("precioPorHora");
                String fechaInicio = rs.getString("fechaInicio");
                String fechaFin = rs.getString("fechaFin");
                String horaInicio = rs.getString("horaInicio");
                String horaFin = rs.getString("horaFin");
                String complemento = rs.getString("complemento");
                String fechaCreacion = rs.getString("fechaCreacion");
                int estado = rs.getInt("estado");
                String descripcion = rs.getString("nombreEmpleo");
                propuesta = new Propuesta();
                propuesta.setDescripcion(descripcion);
                propuesta.setIdPropuesta(idPropuesta);
                String nombresUsuario = rs.getString("nombres");
                String apellidosUsuario = rs.getString("apellidos");
                int idUsuario = rs.getInt("idUsuario");
                
                usuario = new Usuario(idUsuario);
                usuario.setNombres(nombresUsuario);
                usuario.setApellidos(apellidosUsuario);
                      
                oferta = new Oferta(idOferta,propuesta,precioPorHora,fechaInicio, fechaFin,horaInicio, 
                        horaFin, complemento, fechaCreacion, estado, usuario);
            
                ofertas.add(oferta);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return ofertas;
    }

    @Override
    public Oferta findOfertaById(Oferta oferta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Alerta insertarOferta(Oferta oferta) {
        Connection conn = null;
        
        PreparedStatement stmt = null;
        int rows = 0;
        int estado;
        Comentario comentario = null;
        Alerta alerta = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, oferta.getPropuesta().getIdPropuesta());
            stmt.setInt(2, oferta.getPrecioPorHora());
            stmt.setString(3, oferta.getFechaInicio());
            stmt.setString(4, oferta.getFechaFin());
            stmt.setString(5, oferta.getHoraInicio());
            stmt.setString(6, oferta.getHoraFin());
            stmt.setString(7, oferta.getComplemento());
            stmt.setInt(8, oferta.getEstado());
            stmt.setInt(9, oferta.getUsuario().getIdUsuario());
            System.out.print(SQL_INSERT);
            System.out.print("hola mundo ...");
            rows = stmt.executeUpdate();
            String contenidoComentario = "La oferta es: \n\n DE: " + oferta.getFechaInicio() + " AL: " + oferta.getFechaFin()
                    +"\n HORARIO: " + oferta.getHoraInicio() + "-" + oferta.getHoraFin() + "\n OFREZCO POR HORA: "
                    +"Q."+oferta.getPrecioPorHora() +"\n " + oferta.getComplemento();
            
           
            comentario = new Comentario();
            comentario.setContenido(contenidoComentario);
            comentario.setRecibeEnvia(2);//Es mensaje del que ofrece
            comentario.setEstado(1);//Estado 1 por default
            comentario.setProupesta(oferta.getPropuesta());
            comentario.setOferta(oferta); 
            
            alerta = new ComentarioDao().insertarComentario(comentario);
            alerta = new Alerta(SUCCESS, "Oferta Enviada exitosamente");
            

        } catch (SQLException ex) {
            alerta = new Alerta(ERROR, "Error al crear la oferta 1" + ex.toString());
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PropuestaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            alerta = new Alerta(ERROR, "Error al crear la oferta 2" + ex.toString());
        } catch (InstantiationException ex) {
            Logger.getLogger(OfertaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(OfertaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return alerta;
    }

    @Override
    public Alerta actualizarOferta(Oferta oferta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Alerta deleteOferta(Oferta oferta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
