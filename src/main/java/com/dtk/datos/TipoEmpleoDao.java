/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.datos;

import com.dtk.dominio.TipoEmpleo;
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
public class TipoEmpleoDao {
    public static String query = " WHERE 1 = 1 "; 
    public static final String SQL_SELECT = "SELECT idTipoEmpleo, nombreEmpleo, descripcion "
            + "FROM  tipoEmpleo " + query +" ORDER BY nombreEmpleo ASC";

    public List<TipoEmpleo> findAllEmpleos(String query) throws InstantiationException, IllegalAccessException {
        TipoEmpleoDao.query += query;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TipoEmpleo empleo = null;
        List<TipoEmpleo> tiposEmpleos  = new ArrayList<>();
        try {
            try {
                conn = Conexion.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TipoEmpleoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(SQL_SELECT);
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idTipoEmpleo = rs.getInt("idTipoEmpleo");
                String nombreEmpleo = rs.getString("nombreEmpleo");
                String descripcion = rs.getString("descripcion");
                empleo = new TipoEmpleo(idTipoEmpleo, nombreEmpleo, descripcion);
                tiposEmpleos.add(empleo);
            }
            
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
       return tiposEmpleos;
    }
}
