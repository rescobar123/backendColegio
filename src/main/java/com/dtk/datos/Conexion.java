package com.dtk.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
   /*private static final String JDBC_URL = "jdbc:mysql://64.225.105.3:3306/dtk?useSSL=false&useTimezone=true&serverTimezone=UTC"
            + "&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "dtk";
    private static final String JDBC_PASSWORD = "dtk";*/
    
     private static final String JDBC_URL = "jdbc:mysql://localhost:3306/rescobar?useSSL=false&useTimezone=true&serverTimezone=UTC"
            + "&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    
    
    public static DataSource getDataSource(){
        BasicDataSource ds  = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        ds.setInitialSize(500);
        return ds;
    }
    
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
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
