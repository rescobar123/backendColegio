/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.datos;

import com.dtk.complementos.Alerta;
import static com.dtk.complementos.Global.ERROR;
import static com.dtk.complementos.Global.SUCCESS;
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
import static com.dtk.complementos.Global.AUTOINCREMENT_OFERTA;

/**
 *
 * @author robinescobar
 */
public class OfertaDaoImpl implements OfertaDao {

    public static final String SQL_INSERT = "INSERT INTO oferta"
            + "(idOferta, idPropuesta, precioPorHora, fechaInicio, fechaFin, "
            + "horaInicio, horaFin, complemento, fechaCreacion, estado, idUsuarioCreoOferta, idTipoEmpleo, oferta) VALUES "
            + "(NULL, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, ?, 0, '' );";

    public static final String SQL_INSERT_OFERTA_PROPUESTA = "INSERT INTO ofertaPropuesta"
            + "(idOfertaAplicada, idOferta, fechaAplicacion, estado, "
            + "idPropuesta) VALUES "
            + "(NULL,(" + AUTOINCREMENT_OFERTA + "),NOW(), ?, ?);";

    public static final String SQL_SELECT_OFERTA_APLICADA = "SELECT prop.idUsuarioCreo "
            + " FROM propuesta prop "
            + " JOIN ofertaPropuesta oferProp ON  prop.idPropuesta = oferProp.idPropuesta "
            + " WHERE oferProp.idOferta = ? AND prop.idUsuarioCreo = ? ";

    public static final String SQL_INSERT_PUBLIC = "INSERT INTO oferta"
            + "(idOferta, idPropuesta, precioPorHora, fechaInicio, fechaFin, "
            + "horaInicio, horaFin, complemento, fechaCreacion, estado, idUsuarioCreoOferta, idTipoEmpleo, oferta) VALUES "
            + "(NULL, ?, ?, CURDATE(), CURDATE(), ?, ?, ?, NOW(), ?, ?, ?, ? );";

    public static final String SQL_SELECT = "SELECT ofer.idOferta, ofer.idPropuesta, ofer.precioPorHora, "
            + " ofer.fechaInicio, ofer.fechaFin,ofer.horaInicio, ofer.horaFin, ofer.complemento, "
            + " ofer.fechaCreacion, ofer.estado, tip.nombreEmpleo,user.foto ,user.nombres, user.apellidos, user.idUsuario "
            + " FROM oferta ofer "
            + " JOIN propuesta prop ON ofer.idPropuesta = prop.idPropuesta "
            + " JOIN tipoEmpleo tip ON prop.idTipoPropuesta = tip.idTipoEmpleo "
            + " JOIN usuario user ON ofer.idUsuarioCreoOferta = user.idUsuario "
            + "  WHERE 1 = 1 AND ofer.idPropuesta != 0 ";

    public static final String SQL_SELECT_PUBLIC = "SELECT ofer.oferta, ofer.estado, ofer.idOferta, ofer.precioPorHora, ofer.complemento,"
            + " ofer.fechaCreacion"
            + " FROM oferta ofer "
            + " WHERE 1 = 1 AND ofer.idPropuesta = 0 ";

    public static final String SQL_DELETE = "DELETE FROM oferta WHERE idOferta = ?";

    public static final String SQL_UPDATE = "UPDATE oferta SET estado = ? WHERE idOferta = ?";

    @Override
    public List<Oferta> findAllOferasPublic(String query, int idUsuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        Oferta oferta = null;
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
            System.out.println(SQL_SELECT_PUBLIC + query);
            stmt = conn.prepareStatement(SQL_SELECT_PUBLIC + query + " ORDER BY fechaCreacion DESC");
            rs = stmt.executeQuery();
            while (rs.next()) {
                int estado = rs.getInt("estado");
                int idOferta = rs.getInt("idOferta");
                int precioPorHora = rs.getInt("precioPorHora");
                String complemento = rs.getString("complemento");
                String fechaCreacion = rs.getString("fechaCreacion");
                String ofer = rs.getString("oferta");

                oferta = new Oferta();
                oferta.setEstado(estado);
                oferta.setIdOferta(idOferta);
                oferta.setPrecioPorHora(precioPorHora);
                oferta.setComplemento(complemento);
                oferta.setFechaCreacion(fechaCreacion);
                oferta.setOferta(ofer);

                if (idUsuario != 0) {
                    stmt2 = conn.prepareStatement(SQL_SELECT_OFERTA_APLICADA);
                    stmt2.setInt(1, idOferta);
                    stmt2.setInt(2, idUsuario);
                    rs2 = stmt2.executeQuery();
                    if (rs2.next()) {
                        int idUsuarioDB = rs2.getInt("idUsuarioCreo");
                        usuario = new Usuario();
                        usuario.setIdUsuario(idUsuarioDB);
                        oferta.setUsuario(usuario);
                    }else{
                        int idUsuarioDB = 0;
                        usuario = new Usuario();
                        usuario.setIdUsuario(idUsuarioDB);
                        oferta.setUsuario(usuario);
                    }
                }
                
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
                String foto = rs.getString("foto");
                propuesta = new Propuesta();
                propuesta.setDescripcion(descripcion);
                propuesta.setIdPropuesta(idPropuesta);
                String nombresUsuario = rs.getString("nombres");
                String apellidosUsuario = rs.getString("apellidos");
                int idUsuario = rs.getInt("idUsuario");

                usuario = new Usuario(idUsuario);
                usuario.setNombres(nombresUsuario);
                usuario.setApellidos(apellidosUsuario);
                usuario.setFoto(foto);
                oferta = new Oferta(idOferta, propuesta, precioPorHora, fechaInicio, fechaFin, horaInicio,
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
        PreparedStatement stmt2 = null;
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
            stmt2 = conn.prepareStatement(SQL_INSERT_OFERTA_PROPUESTA);
            stmt2.setInt(1, 1);
            stmt2.setInt(2, oferta.getPropuesta().getIdPropuesta());
            stmt2.executeUpdate();
            rows = stmt.executeUpdate();

            String contenidoComentario = "La oferta es: \n\n DE: " + oferta.getFechaInicio() + " AL: " + oferta.getFechaFin()
                    + "\n HORARIO: " + oferta.getHoraInicio() + "-" + oferta.getHoraFin() + "\n OFREZCO POR HORA: "
                    + "Q." + oferta.getPrecioPorHora() + "\n OBSERVACIONES: " + oferta.getComplemento();

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
    public Alerta insertarOfertaPublic(Oferta oferta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        int estado;
        Alerta alerta = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_PUBLIC);
            stmt.setInt(1, oferta.getPropuesta().getIdPropuesta());
            stmt.setInt(2, oferta.getPrecioPorHora());
            stmt.setString(3, "--");
            stmt.setString(4, "--");
            stmt.setString(5, oferta.getComplemento());
            stmt.setInt(6, oferta.getEstado());
            stmt.setInt(7, oferta.getUsuario().getIdUsuario());
            stmt.setInt(8, oferta.getIdTipoEmpleo());
            stmt.setString(9, oferta.getOferta());
            System.out.print(SQL_INSERT_PUBLIC);
            rows = stmt.executeUpdate();
            alerta = new Alerta(SUCCESS, "Oferta publicada exitosamente");

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
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Alerta alerta = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, oferta.getEstado());
            stmt.setInt(2, oferta.getIdOferta());
            System.out.print(SQL_UPDATE);
            rows = stmt.executeUpdate();
            if (oferta.getEstado() == 1) {
                alerta = new Alerta(SUCCESS, "HABILITADA, Sera visible para las personas ");
            } else {
                alerta = new Alerta(SUCCESS, "DES-HABILITADA, NO sera visible para las personas ");
            }

        } catch (SQLException ex) {
            alerta = new Alerta(ERROR, "Error al deshabilitar la propuesta 1", ex.toString());
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PropuestaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            alerta = new Alerta(ERROR, "Error al deshabilitar la propuesta 2", ex.toString());
        } catch (InstantiationException ex) {
            Logger.getLogger(PropuestaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PropuestaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return alerta;
    }

    @Override
    public Alerta deleteOferta(Oferta oferta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Alerta alerta = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, oferta.getIdOferta());
            System.out.print(SQL_DELETE);
            rows = stmt.executeUpdate();

            alerta = new Alerta(SUCCESS, "La oferta se ha eliminado correctamente ");

        } catch (SQLException ex) {
            alerta = new Alerta(ERROR, "Error al eliminar la oferta 1" + ex.toString());
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PropuestaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            alerta = new Alerta(ERROR, "Error al eliminar la oferta 2" + ex.toString());
        } catch (InstantiationException ex) {
            Logger.getLogger(PropuestaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PropuestaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return alerta;
    }

}
