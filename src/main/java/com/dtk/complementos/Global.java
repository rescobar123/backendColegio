/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtk.complementos;

/**
 *
 * @author robinescobar
 */
public class Global {

   public static int ID_COLEGIO = 1;
   public static String SUCCESS = "success";
   public static String ERROR = "error";
   public static String ROL_ALUMNO = "ALUM";
   public static String AUTOINCREMENT = "SELECT `AUTO_INCREMENT` + "
           + "1 FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'chance' "
           + "AND   TABLE_NAME   = 'oferta' ";
   public static String KEY_JWT = "colegio";
   public static long DATE_ACTUAL = System.currentTimeMillis();
}
