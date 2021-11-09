/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dtk.datos;

import static com.dtk.datos.VehiculoDAOimpl.SQL_DELETE;
import static com.dtk.datos.VehiculoDAOimpl.SQL_INSERT;
import com.dtk.dominio.Propietario;
import com.dtk.dominio.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class PropietarioDAOimpl implements PropietarioDAO {
    public static final String SQL_SELECT = "SELECT id, PropietarioNombres, PropietarioApellidos, PropietarioIdentificacion, "
            + "PropietarioFechaNaci, PropietarioDireccion, PropietarioTelefono, PropietarioEmail, PropietarioEstado, "
            + "PropietarioFechaCreado FROM propietario";
    public static final String SQL_FIND_BY_ID = "SELECT id, PropietarioNombres, PropietarioApellidos, PropietarioIdentificacion, "
            + "PropietarioFechaNaci, PropietarioDireccion, PropietarioTelefono, PropietarioEmail, PropietarioEstado, "
            + "PropietarioFechaCreado FROM propietario WHERE id = ?";
    public static final String SQL_INSERT = "INSERT INTO vehiculopersona (PersonaId, VehiculoId) VALUES ( ?, ?);";
    
    public static final String SQL_DELETE = "DELETE FROM vehiculopersona WHERE PersonaId =   ? AND VehiculoId = ?;";
    
    @Override
    public List<Propietario> findAllPropietarios() {
         Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Propietario propietario = null;
        
        List<Propietario> propietarios  = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nombres = rs.getString("PropietarioNombres");
                String apellidos = rs.getString("PropietarioApellidos");
                String identificacion = rs.getString("PropietarioIdentificacion");
                String fechaNaci = rs.getString("PropietarioFechaNaci");
                String direccion = rs.getString("PropietarioDireccion");
                String telefono = rs.getString("PropietarioTelefono");
                String email = rs.getString("PropietarioEmail");
                String estado = rs.getString("PropietarioEstado");
                String fechaCreado = rs.getString("PropietarioFechaCreado");
                propietario = new Propietario(id, nombres,apellidos,identificacion,fechaNaci, direccion,telefono, email, estado, fechaCreado);
                propietarios.add(propietario);
            }
            
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
       return propietarios;
    }

    @Override
    public Propietario finfPropietarioById(Propietario propietario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_FIND_BY_ID);
            stmt.setInt(1, propietario.getId());
            rs = stmt.executeQuery();
            rs.absolute(1);
            String nombres = rs.getString("PropietarioNombres");
            String apellidos = rs.getString("PropietarioApellidos");
            String identificacion = rs.getString("PropietarioIdentificacion");
            String fechaNaci = rs.getString("PropietarioFechaNaci");
            String direccion = rs.getString("PropietarioDireccion");
            String telefono = rs.getString("PropietarioTelefono");
            String email = rs.getString("PropietarioEmail");
            String estado = rs.getString("PropietarioEstado");
            String fechaCreado = rs.getString("PropietarioFechaCreado");
            
            propietario.setNombre(nombres);
            propietario.setApellido(apellidos);
            propietario.setIdentificacion(identificacion);
            propietario.setFechaNaci(fechaNaci);
            propietario.setDireccion(direccion);
            propietario.setTelefono(telefono);
            propietario.setEmail(email);
            propietario.setEstado(estado);
            propietario.setFechaCreacion(fechaCreado);
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return propietario;
    }

    public String insertVehiculoPropiead(Propietario propietario, Vehiculo vehi) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        String mensajeRespuesta = "";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, propietario.getId());
            stmt.setInt(2, vehi.getIdVehiculo());
            
            rows =  stmt.executeUpdate();
            mensajeRespuesta = "Asociado";
            
        } catch (SQLException ex) {
            mensajeRespuesta = "Error" + ex;
           ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return mensajeRespuesta;
    }

    public String desasociarVehiculoPropietario(Propietario propietario, Vehiculo vehi) {
        Connection conn = null;
        PreparedStatement stmt = null;
        String mensajeRespuesta = "";
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, propietario.getId());
            stmt.setInt(2, vehi.getIdVehiculo());
            
            rows = stmt.executeUpdate();
            mensajeRespuesta = "Desasociado";
        } catch (SQLException ex) {
            mensajeRespuesta = "Error " + ex;
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return mensajeRespuesta;
    }
    
}
