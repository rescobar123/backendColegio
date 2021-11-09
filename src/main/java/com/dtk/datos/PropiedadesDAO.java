/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dtk.datos;


import com.dtk.dominio.Propiedades;
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
public class PropiedadesDAO {
       public static final String SQL_SELECT = "SELECT C.id AS idPersona,  C.PropietarioNombres,"
               + "C.PropietarioApellidos, B.VehiculoPlaca, B.VehiculoMarca, B.VehiculoColor, B.id AS idVehiculo "
               + "FROM vehiculopersona A JOIN vehiculo B ON B.id = A.VehiculoId JOIN propietario C ON A.PersonaId = C.id";
        public static final String SQL_SELECT_BY_IDPERSONA = "SELECT A.id as idVehiculo, A.VehiculoPlaca, A.VehiculoColor, "
                + "A.VehiculoMarca, A.VehiculoLinea, A.VehiculoTipo, A.VehiculoModelo"
                + " from vehiculo A JOIN vehiculopersona B ON A.id = "
                + "B.VehiculoId where B.PersonaId = ?";
      
    public  List<Propiedades> findAllPropiedades(int idPersona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vehiculo vehiculo = null;
        Propietario propietario = null;
        List<Propiedades> propiedades  = new ArrayList<>();
        Propiedades propiedad = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            
           
            rs = stmt.executeQuery();
            while(rs.next()){
                int idVehiculo = rs.getInt("idVehiculo");
                String placa = rs.getString("VehiculoPlaca");
                String color = rs.getString("Vehiculocolor");
                String descripcion = "";
                String marca = rs.getString("VehiculoMarca");
                String linea = "";
                String cilindraje = "";
                String chasis ="";
                String tipo = "";
                String modelo ="";
                String fechaCreacion = "";
                String estado = "";
                
                
                vehiculo = new Vehiculo(idVehiculo, placa, color, descripcion, marca, linea, cilindraje, chasis, tipo, modelo, fechaCreacion, estado );
                int idPropietario = rs.getInt("idPersona");
                String nombres = rs.getString("PropietarioNombres");
                String apellidos = rs.getString("PropietarioApellidos");
                String identificacion = "";
                String fechaNaci = "";
                String direccion = "";
                String telefono ="";
                String email = "";
                String estadoPersona = "";
                String fechaCreado ="";
                propietario = new Propietario(idPropietario, nombres,apellidos,identificacion,fechaNaci, direccion,telefono, email, estadoPersona, fechaCreado);
               
                propiedad = new Propiedades(propietario, vehiculo);
                propiedades.add(propiedad);
            }
            
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        Conexion.close(conn);
       return propiedades;
    }
    
    
    public  List<Propiedades> getPropieadesPersona(int idPersona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Propiedades> propiedades  = new ArrayList<>();
        Propiedades propiedad = null;
        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_SELECT_BY_IDPERSONA);
            stmt.setInt(1, idPersona); 
            
            rs = stmt.executeQuery();
            while(rs.next()){
                int idVehiculo = rs.getInt("idVehiculo");
                String placa = rs.getString("VehiculoPlaca");
                String color = rs.getString("Vehiculocolor");
                String marca = rs.getString("VehiculoMarca");
                String linea = rs.getString("VehiculoLinea");
                String tipo = rs.getString("VehiculoTipo");
                String modelo =rs.getString("VehiculoModelo");
                
                propiedad = new Propiedades(idVehiculo, placa, color, marca, linea, tipo, modelo);
                propiedades.add(propiedad);
            }
            
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
       return propiedades;
    }
    
}
