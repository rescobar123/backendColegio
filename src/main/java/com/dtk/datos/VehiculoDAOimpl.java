package com.dtk.datos;

import com.dtk.dominio.Vehiculo;
import java.sql.*;
import java.util.*;
import javax.persistence.Convert;

/**
 *
 * @author admin
 */
public class VehiculoDAOimpl implements VehiculoDAO {
    public static final String SQL_SELECT = "SELECT id, VehiculoPlaca, VehiculoColor, VehiculoDescripcion, VehiculoMarca, "
            + "VehiculoLinea, VehiculoCilindraje, VehiculoChasis, VehiculoTipo, VehiculoModelo, "
            + "VehiculoFechaCreacion, VehiculoEstado FROM vehiculo";
    public static final String SQL_FIND_BY_ID = "SELECT id, VehiculoPlaca, VehiculoColor, VehiculoDescripcion, VehiculoMarca, "
            + "VehiculoLinea, VehiculoCilindraje, VehiculoChasis, VehiculoTipo, VehiculoModelo, "
            + "VehiculoFechaCreacion, VehiculoEstado FROM vehiculo"
            + " WHERE id = ?";
    public static final String SQL_INSERT = "INSERT INTO vehiculo (VehiculoPlaca, VehiculoColor, VehiculoDescripcion, VehiculoMarca, "
            + "VehiculoLinea, VehiculoCilindraje, VehiculoChasis, VehiculoTipo, VehiculoModelo, "
            + "VehiculoFechaCreacion, VehiculoEstado)"
            + " VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, CURDATE(), 1)";
    public static final String SQL_UPDATE = "UPDATE  vehiculo SET VehiculoPlaca = ?, VehiculoColor = ? , VehiculoDescripcion = ?,"
            + "VehiculoMarca = ?, VehiculoLinea = ?, VehiculoCilindraje = ?, VehiculoChasis = ?, VehiculoTipo = ?, VehiculoModelo = ? "
            + " WHERE id = ?";
    public static final String SQL_DELETE = "DELETE FROM vehiculo WHERE id = ?";
    
    @Override
    public  List<Vehiculo> findAllVehiculos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vehiculo vehiculo = null;
        
        List<Vehiculo> vehiculos  = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idVehiculo = rs.getInt("id");
                String placa = rs.getString("VehiculoPlaca");
                String color = rs.getString("Vehiculocolor");
                String descripcion = rs.getString("VehiculoDescripcion");
                String marca = rs.getString("VehiculoMarca");
                String linea = rs.getString("VehiculoLinea");
                String cilindraje = rs.getString("VehiculoCilindraje");
                String chasis = rs.getString("VehiculoChasis");
                String tipo = rs.getString("VehiculoTipo");
                String modelo = rs.getString("VehiculoModelo");
                String fechaCreacion = rs.getString("VehiculoFechaCreacion");
                String estado = rs.getString("VehiculoEstado");
                vehiculo = new Vehiculo(idVehiculo, placa, color, descripcion, marca, linea, cilindraje, chasis, tipo, modelo, fechaCreacion, estado );
                vehiculos.add(vehiculo);
            }
            
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
       return vehiculos;
    }

    @Override
    public Vehiculo findVehiculoById(Vehiculo vhcl) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_FIND_BY_ID);
            stmt.setInt(1, vhcl.getIdVehiculo());
            rs = stmt.executeQuery();
            rs.absolute(1);
            String placa = rs.getString("VehiculoPlaca");
            String color = rs.getString("Vehiculocolor");
            String descripcion = rs.getString("VehiculoDescripcion");
            String marca = rs.getString("VehiculoMarca");
            String linea = rs.getString("VehiculoLinea");
            String cilindraje = rs.getString("VehiculoCilindraje");
            String chasis = rs.getString("VehiculoChasis");
            String tipo = rs.getString("VehiculoTipo");
            String modelo = rs.getString("VehiculoModelo");
            String fechaCreacion = rs.getString("VehiculoFechaCreacion");
            String estado = rs.getString("VehiculoEstado");
            vhcl.setPlaca(placa);
            vhcl.setColor(color);
            vhcl.setDescripcion(descripcion);
            vhcl.setMarca(marca);
            vhcl.setLinea(linea);
            vhcl.setCilindraje(cilindraje);
            vhcl.setChasis(chasis);
            vhcl.setTipo(tipo);
            vhcl.setModelo(modelo);
            vhcl.setFechaCreacion(fechaCreacion);
            vhcl.setEstado(estado);
            
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return vhcl;
    }

    @Override
    public String insertVehiculo(Vehiculo vhcl) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        String mensajeRespuesta = "";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vhcl.getPlaca());
            stmt.setString(2, vhcl.getColor());
            stmt.setString(3, vhcl.getDescripcion());
            stmt.setString(4, vhcl.getMarca());
            stmt.setString(5, vhcl.getLinea());
            stmt.setString(6, vhcl.getCilindraje());
            stmt.setString(7, vhcl.getChasis());
            stmt.setString(8, vhcl.getTipo());
            stmt.setString(9, vhcl.getModelo());
            
            rows =  stmt.executeUpdate();
            mensajeRespuesta = "Ingresado";
            
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return mensajeRespuesta;
    }

    @Override
    public String updateVehiculo(Vehiculo vhcl) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        String mensajeRespuesta = "";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vhcl.getPlaca());
            stmt.setString(2, vhcl.getColor());
            stmt.setString(3, vhcl.getDescripcion());
            stmt.setString(4, vhcl.getMarca());
            stmt.setString(5, vhcl.getLinea());
            stmt.setString(6, vhcl.getCilindraje());
            stmt.setString(7, vhcl.getChasis());
            stmt.setString(8, vhcl.getTipo());
            stmt.setString(9, vhcl.getModelo());
            stmt.setInt(10, vhcl.getIdVehiculo());
            
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
    public String deleteVehiculo(Vehiculo vhcl) {
        Connection conn = null;
        PreparedStatement stmt = null;
        String mensajeRespuesta = "cc";
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, vhcl.getIdVehiculo());
            
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
