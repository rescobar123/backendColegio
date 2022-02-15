package com.dtk.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mysql.jdbc.*;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
   /*private static final String JDBC_URL = "jdbc:mysql://64.225.105.3:3306/dtk?useSSL=false&useTimezone=true&serverTimezone=UTC"
            + "&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "dtk";
    private static final String JDBC_PASSWORD = "dtk";*/
    
   /*private static final String JDBC_URL = "jdbc:mysql://localhost:3306/chanceco_chance";
    private static final String JDBC_USER = "chanceco_chanceuser";
    private static final String JDBC_PASSWORD = "ChanceUser2022";
    */
    
    private static final String JDBC_URL = "jdbc:mysql://192.168.0.12:3306/chance?useSSL=false&useTimezone=true&serverTimezone=UTC"
            + "&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "rescobar";
    private static final String JDBC_PASSWORD = "Rescobar$2020$";
    
    
    private static Connection conn = null;
    public static DataSource getDataSource(){
        BasicDataSource ds  = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        ds.setInitialSize(500);
        return ds;
    }
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        System.out.println("**OBTENIENDO CONEXION**");
        try{ 
           System.out.println("**OBTENIENDO CONEXION 2**" );
          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
           System.out.print("Obteniendo la conexion nueva perros...");
           return conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        //   return  conn = (Connection) DriverManager.getConnection();
        } catch (SQLException ex) {
             System.out.print("Error en la conexion" + ex.toString());
            ex.printStackTrace(System.out);
        }
        System.out.println("**OBTENIENDO CONEXION 4**" );
         return null;
    }

    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
