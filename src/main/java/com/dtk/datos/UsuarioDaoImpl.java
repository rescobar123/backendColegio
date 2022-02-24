/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.datos;

import com.dtk.complementos.Alerta;
import com.dtk.complementos.ChanceUtils;
import static com.dtk.complementos.Global.ERROR;
import static com.dtk.complementos.Global.SUCCESS;
import com.dtk.dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author robinescobar
 */
public class UsuarioDaoImpl implements UsuarioDAO {

    public static final String SQL_FIND_USER = "SELECT  email, nombres, apellidos, idUsuario, direccion, educacion, rol,  genero, cv, foto, email, password, "
            + "fechaNacimiento, educacion, vacunaCovid FROM usuario ";
    public static final String SQL_INSERT = "INSERT INTO usuario (idUsuario, email, password, nombres, apellidos, rol, direccion, fechaNacimiento"
            + ", educacion, genero, vacunaCovid, cv, foto, fechaCreacion) "
            + "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW());";
    public static final String SQL_SELECT_BY_ID = "SELECT nombres, apellidos, direccion, profesion, genero, cv, foto, email, password, "
            + "fechaNacimiento, educacion, vacunaCovid"
            + " FROM usuario "
            + " WHERE idUsuario = ?";

    @Override
    public Usuario validarUsuario(Usuario usuario) {
        System.out.println(" + + + + + + Validando usuario: + + + + + + + " + usuario.toString());
        //String query = " WHERE email = '" + usuario.getEmail() + "'";
        Usuario usuarioDb = this.findUserByNickPassword(usuario);
        if (usuarioDb.getNombres() != null) {
            System.out.println("USUARIO validado***" + usuarioDb.toString());
            usuario.setNombres(usuarioDb.getNombres());
            usuario.setApellidos(usuarioDb.getApellidos());
            usuario.setRol(usuarioDb.getRol());
            usuario.setIdUsuario(usuarioDb.getIdUsuario());
            usuario.setIdUsuario(usuarioDb.getIdUsuario());
            return usuario;
        } else {
            return null;
        }
    }

    @Override
    public Usuario findUserByNickPassword(Usuario usuario) {
        
        System.out.println("**BUSCANDO USUARIO**");
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            try {
                 System.out.print("CONEXION OBTENDIA la conexion");
                conn = Conexion.getConnection();
               
            } catch (ClassNotFoundException ex) {
                System.out.print("no se puedo obetener la conexion" + ex);
                Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
             System.out.print("NO SE QUE PASA OBTENDIA la conexion");
            stmt = conn.prepareStatement(SQL_FIND_USER +  " WHERE email = ?");
            stmt.setString(1, usuario.getEmail());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String password = rs.getString("password");
                if (usuario.getPassword().equals(ChanceUtils.getAESDecrypt(password))) {
                    String nombres = rs.getString("nombres");
                    String apellidos = rs.getString("apellidos");
                    String rol = rs.getString("rol");
                    int idUsuario = rs.getInt("idUsuario");
                    //String cv = rs.getString("cv");
                    String direccion = rs.getString("direccion");
                    String educacion = rs.getString("educacion");
                    String fechaNacimiento = rs.getString("fechaNacimiento");
                    //String foto = rs.getString("foto");
                    String genero = rs.getString("genero");
                    String vacunaCovid = rs.getString("vacunaCovid");
                    usuario.setNombres(nombres);
                    usuario.setApellidos(apellidos);
                    usuario.setRol(rol);
                    usuario.setIdUsuario(idUsuario);
                  //  usuario.setCv(cv);
                    usuario.setDireccion(direccion);
                    usuario.setEducacion(educacion);
                    usuario.setFechaNacimiento(fechaNacimiento);
                    //usuario.setFoto(foto);
                    usuario.setGenero(genero);
                    usuario.setVacunaCovid(vacunaCovid);
                } else {
                    return usuario;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return usuario;
    }

    @Override
    public Alerta insertarUsuario(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        int estado;
        Alerta alerta = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, ChanceUtils.getAES(usuario.getPassword()));
            stmt.setString(3, usuario.getNombres());
            stmt.setString(4, usuario.getApellidos());
            stmt.setString(5, usuario.getRol());
            stmt.setString(6, usuario.getDireccion());
            stmt.setString(7, usuario.getFechaNacimiento());
            stmt.setString(8, usuario.getEducacion());
            stmt.setString(9, usuario.getGenero());
            stmt.setString(10, usuario.getVacunaCovid());
            stmt.setString(11, usuario.getCv());
            stmt.setString(12, usuario.getFoto());

            System.out.print(SQL_INSERT);
            System.out.print("hola mundo ...");
            rows = stmt.executeUpdate();

            alerta = new Alerta(SUCCESS, "Se ha creado la cuenta correctamente");

        } catch (SQLException ex) {
            alerta = new Alerta(ERROR, "Error al crear la cuenta 1", ex.toString());
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            alerta = new Alerta(ERROR, "Error al crear la cuenta 2", ex.toString());
        } catch (InstantiationException ex) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return alerta;
    }

    @Override
    public Usuario findUser(String query) {
        Usuario usuario = new Usuario();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            try {
                conn = Conexion.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print(SQL_FIND_USER +  query);
            stmt = conn.prepareStatement(SQL_FIND_USER +  query);
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                    String nombres = rs.getString("nombres");
                    String apellidos = rs.getString("apellidos");
                    String rol = rs.getString("rol");
                    int idUsuario = rs.getInt("idUsuario");
                    String cv = rs.getString("cv");
                    String direccion = rs.getString("direccion");
                    String educacion = rs.getString("educacion");
                    String fechaNacimiento = rs.getString("fechaNacimiento");
                    String foto = rs.getString("foto");
                    String genero = rs.getString("genero");
                    String vacunaCovid = rs.getString("vacunaCovid");
                    String email = rs.getString("email");
                    usuario.setEmail(email);
                    usuario.setNombres(nombres);
                    usuario.setApellidos(apellidos);
                    usuario.setRol(rol);
                    usuario.setIdUsuario(idUsuario);
                    usuario.setCv(cv);
                    usuario.setDireccion(direccion);
                    usuario.setEducacion(educacion);
                    usuario.setFechaNacimiento(fechaNacimiento);
                    usuario.setFoto(foto);
                    usuario.setGenero(genero);
                    usuario.setVacunaCovid(vacunaCovid);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return usuario;
        
    }

}
