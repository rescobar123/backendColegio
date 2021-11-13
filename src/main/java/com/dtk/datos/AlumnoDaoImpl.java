/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.datos;


import com.dtk.dominio.Alumno;
import com.dtk.dominio.CentroEducativo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robin.escobar
 */
public class AlumnoDaoImpl implements AlumnoDAO {
    
    public static final String SQL_SELECT = "SELECT idAlumno, idCentroEducativo, codigoAlumno, nombres, "
            + "apellidos, direccion, celular, estado, observacion, fechaCreacion FROM alumno";
    public static final String SQL_FIND_BY_ID = "SELECT idAlumno, idCentroEducativo, codigoAlumno, nombres, "
            + "apellidos, direccion, celular, estado, observacion, fechaCreacion FROM alumno WHERE idAlumno = ?";
    
    public static final String SQL_UPDATE = "UPDATE  alumno  SET codigoAlumno = ?, nombres = ?, "
            + "apellidos = ?, direccion = ?, celular = ?, estado = ?, observacion = ?, fechaCreacion = ? WHERE idAlumno = ?";
    
    public static final String SQL_INSERT = "INSERT INTO alumno (idCentroEducativo, codigoAlumno, nombres, "
            + "apellidos, direccion, celular, estado, observacion, fechaCreacion) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    
    public static final String SQL_DELETE = "DELETE FROM alumno WHERE idAlumno =  ?";

    @Override
    public List<Alumno> findAllAlumnos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Alumno alumno = null;
        CentroEducativo centroEducativo = null;
        
        List<Alumno> alumnos  = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idAlumno = rs.getInt("idAlumno");
                int idCentroEducativo = rs.getInt("idCentroEducativo");
                String codigoAlumno = rs.getString("codigoAlumno");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String direccion = rs.getString("direccion");
                int celular = rs.getInt("celular");
                int estado = rs.getInt("estado");
                String observacion = rs.getString("observacion");
                String fechaCreacion = rs.getString("fechaCreacion");
                centroEducativo = new CentroEducativo(idCentroEducativo);
                
                alumno = new Alumno(idAlumno, centroEducativo, codigoAlumno, nombres, apellidos, direccion, 
                celular, estado, observacion, fechaCreacion);
                alumnos.add(alumno);
            }
            
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
       return alumnos;
    }

    @Override
    public Alumno findAlumnoById(Alumno alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CentroEducativo centroEducativo;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_FIND_BY_ID);
            stmt.setInt(1, alumno.getIdAlumno());
            rs = stmt.executeQuery();
            rs.absolute(1);
             int idCentroEducativo = rs.getInt("idCentroEducativo");
                String codigoAlumno = rs.getString("codigoAlumno");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String direccion = rs.getString("direccion");
                int celular = rs.getInt("celular");
                int estado = rs.getInt("estado");
                String observacion = rs.getString("observacion");
                String fechaCreacion = rs.getString("fechaCreacion");
                centroEducativo = new CentroEducativo(idCentroEducativo);
            
            alumno.setCentroEducativo(centroEducativo);
            alumno.setCodigoAlumno(codigoAlumno);
            alumno.setNombres(nombres);
            alumno.setApellidos(apellidos);
            alumno.setDireccion(direccion);
            alumno.setCelular(celular);
            alumno.setEstado(estado);
            alumno.setObservacion(observacion);
            alumno.setFechaCreacion(fechaCreacion);
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return alumno;
    }

    @Override
    public String insertAlumno(Alumno alumno) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        int idCentroEducativo  =  alumno.getCentroEducativo().getIdCentroEducativo();
        String mensajeRespuesta = "";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, idCentroEducativo);
            stmt.setString(2, alumno.getCodigoAlumno());
            stmt.setString(3, alumno.getNombres());
            stmt.setString(4, alumno.getApellidos());
            stmt.setString(5, alumno.getDireccion());
            stmt.setInt(6, alumno.getCelular());
            stmt.setInt(7, alumno.getEstado());
            stmt.setString(8, alumno.getObservacion());
            stmt.setString(9, alumno.getFechaCreacion());
            
            
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

    @Override
    public String updateAlumno(Alumno alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        String mensajeRespuesta = "";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, alumno.getCodigoAlumno());
            stmt.setString(2, alumno.getNombres());
            stmt.setString(3, alumno.getApellidos());
            stmt.setString(4, alumno.getDireccion());
            stmt.setInt(5, alumno.getCelular());
            stmt.setInt(6, alumno.getEstado());
            stmt.setString(7, alumno.getObservacion());
            stmt.setString(8, alumno.getFechaCreacion());
            stmt.setInt(9, alumno.getIdAlumno());
            
            rows = stmt.executeUpdate();
            mensajeRespuesta = "Actualizado";
        } catch (SQLException ex) {
            mensajeRespuesta = "Error " + ex;
           ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return mensajeRespuesta;
    }

    @Override
    public String deleteAlumno(Alumno alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        String mensajeRespuesta = "cc";
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, alumno.getIdAlumno());
            
            rows = stmt.executeUpdate();
            mensajeRespuesta = "Eliminado";
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
