/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dtk.datos;

import com.dtk.complementos.Alerta;
import com.dtk.dominio.Usuario;

/**
 *
 * @author robinescobar
 */
public interface UsuarioDAO {
     public Usuario findUserByNickPassword(Usuario usuario);
     public Usuario findUser(String query);
     public Usuario validarUsuario(Usuario usuario);
     public Alerta insertarUsuario(Usuario usuario);
}
