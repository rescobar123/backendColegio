/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.datos;

import com.dtk.complementos.Alerta;
import static com.dtk.complementos.Global.AUTOINCREMENT;
import static com.dtk.complementos.Global.ERROR;
import static com.dtk.complementos.Global.ID_COLEGIO;
import static com.dtk.complementos.Global.ROL_ALUMNO;
import static com.dtk.complementos.Global.SUCCESS;
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
public class PropuestaDaoImpl implements PropuestaDao {

    public static final String SQL_SELECT = "SELECT idPropuesta, idTipoPropuesta, diasLaborables, disponibilidad,"
            + " precioPorHora, lugaresLaborables, descripcion, fechaPropuesta, estado, certificado, idUsuarioCreo"
            + " FROM propuesta "
            + " WHERE 1 = 1 ";
    public static final String SQL_SELECT_USER_EMPLEO = "SELECT prop.idPropuesta, prop.disponibilidad,prop.precioPorHora, "
            + " prop.fechaPropuesta, us.nombres, us.apellidos, prop.estado ,us.cv, us.foto, us.vacunaCovid, us.idUsuario, "
            + " templ.nombreEmpleo FROM propuesta prop JOIN usuario us ON prop.idUsuarioCreo = us.idUsuario JOIN tipoEmpleo templ ON prop.idTipoPropuesta = templ.idTipoEmpleo"
            + " WHERE 1 = 1 ";

    public static final String SQL_INSERT = "INSERT INTO propuesta"
            + "(idPropuesta, idTipoPropuesta, diasLaborables, disponibilidad, precioPorHora, "
            + "lugaresLaborables, descripcion, fechaPropuesta, estado, certificado, idUsuarioCreo) VALUES "
            + "(NULL, ?, ?, ?, ?, ?, ?, NOW(), ?, ?, ?);";
    public static final String SQL_DELETE = "DELETE  FROM propuesta WHERE idPropuesta = ?";
    
    public static final String SQL_UPDATE = "UPDATE  propuesta SET estado = ? WHERE idPropuesta = ?";

    @Override
    public List<Propuesta> findAllPropuestas(String query) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Propuesta propuesta = null;
        Usuario usuario = null;
        List<Propuesta> propuestas = new ArrayList<>();
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
                int idPropuesta = rs.getInt("idPropuesta");
                int idTipoPropuesta = rs.getInt("idTipoPropuesta");
                String diasLaborables = rs.getString("diasLaborables");
                String disponibilidad = rs.getString("disponibilidad");
                String precioPorHora = rs.getString("precioPorHora");
                String lugaresLaborables = rs.getString("lugaresLaborables");
                String descripcion = rs.getString("descripcion");
                String fechaPropuesta = rs.getString("fechaPropuesta");
                int idUsuarioCreo = rs.getInt("idUsuarioCreo");
                int estado = rs.getInt("estado");
                String certificado = rs.getString("certificado");
                usuario = new Usuario(idUsuarioCreo);

                propuesta = new Propuesta(idPropuesta, idTipoPropuesta, diasLaborables, disponibilidad, precioPorHora, lugaresLaborables,
                        descripcion, fechaPropuesta, estado, certificado, usuario);

                propuestas.add(propuesta);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return propuestas;
    }

    @Override
    public Propuesta findPropuestaById(Propuesta propuesta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Alerta insertarPropuesta(Propuesta propuesta) {
        Connection conn = null;
        LocalDate current_date = LocalDate.now();
        int currentYear = current_date.getYear();
        PreparedStatement stmt = null;
        int rows = 0;
        int estado;
        Alerta alerta = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, propuesta.getIdTipoPropuesta());
            stmt.setString(2, propuesta.getDiasLaborables());
            stmt.setString(3, propuesta.getDisponibilidad());
            stmt.setString(4, propuesta.getPrecioPorHora());
            stmt.setString(5, propuesta.getLugaresLaborables());
            stmt.setString(6, propuesta.getDescripcion());
            stmt.setInt(7, 1);
            stmt.setString(8, propuesta.getCertificado());
            stmt.setInt(9, propuesta.getUsuarioCreo().getIdUsuario());
            System.out.print(SQL_INSERT);
            System.out.print("hola mundo ...");
            rows = stmt.executeUpdate();

            alerta = new Alerta(SUCCESS, "La propuesta se ha publicado correctamente, Se te estara notificando cuando recibis alguna oferta de empleo para esta oferta");

        } catch (SQLException ex) {
            alerta = new Alerta(ERROR, "Error al crear la propuesta 1", ex.toString());
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PropuestaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            alerta = new Alerta(ERROR, "Error al crear la propuesta 2", ex.toString());
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
    public Alerta actualizarPropuesta(Propuesta propuesta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Alerta alerta = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, propuesta.getEstado());
            stmt.setInt(2, propuesta.getIdPropuesta());
            System.out.print(SQL_UPDATE);
            rows = stmt.executeUpdate();
            if(propuesta.getEstado() == 1){
                alerta = new Alerta(SUCCESS, "HABILITADA, Sera visible para las personas ");
            }else{
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
    public Alerta deletePropuesta(Propuesta propuesta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Alerta alerta = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, propuesta.getIdPropuesta());
            System.out.print(SQL_DELETE);
            rows = stmt.executeUpdate();

            alerta = new Alerta(SUCCESS, "La propuesta se ha eliminado correctamente ");

        } catch (SQLException ex) {
            alerta = new Alerta(ERROR, "Error al eliminar la propuesta 1", ex.toString());
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PropuestaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            alerta = new Alerta(ERROR, "Error al eliminar la propuesta 2", ex.toString());
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
    public List<Propuesta> findAllPropuestasWithUser(String query) {
     Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Propuesta propuesta = null;
        Usuario usuario = null;
        List<Propuesta> propuestas = new ArrayList<>();
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
            System.out.println(SQL_SELECT_USER_EMPLEO + query + " ORDER BY fechaPropuesta DESC");
            stmt = conn.prepareStatement(SQL_SELECT_USER_EMPLEO + query + " ORDER BY fechaPropuesta DESC");
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPropuesta = rs.getInt("idPropuesta");
                String disponibilidad = rs.getString("disponibilidad");
                String precioPorHora = rs.getString("precioPorHora");
                String fechaPropuesta = rs.getString("fechaPropuesta");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String cv = rs.getString("cv");
                String foto = rs.getString("foto");
                String vacunaCovid = rs.getString("vacunaCovid");
                int estado = rs.getInt("estado");
                int idUsuario = rs.getInt("idUsuario");
                String nombreEmpleo = rs.getString("nombreEmpleo");
                usuario = new Usuario();
                usuario.setNombres(nombres);
                usuario.setApellidos(apellidos);
                usuario.setCv(cv);
                usuario.setVacunaCovid(vacunaCovid);
                usuario.setIdUsuario(idUsuario);
                usuario.setFoto(foto);
                
                propuesta = new Propuesta();
                propuesta.setIdPropuesta(idPropuesta);
                propuesta.setDisponibilidad(disponibilidad);
                propuesta.setPrecioPorHora(precioPorHora);
                propuesta.setFechaPropuesta(fechaPropuesta);
                propuesta.setDescripcion(nombreEmpleo);//Esta mal, no se debio usar el campo descripcion para el nombre del empleo
                propuesta.setUsuarioCreo(usuario);
                propuesta.setEstado(estado);
                propuestas.add(propuesta);
                System.out.println(propuesta);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return propuestas;
    }

}
