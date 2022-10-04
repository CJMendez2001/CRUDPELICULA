/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.crud_peliculas.dao;

import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author mende
 */
public class Conexion {
    private static Connection conn = null;
    
    public static Connection getConnection(){
        try{
        if(conn == null){
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:pelicula.db");
        }
        return conn;
    }catch (Exception ex) {
        System.err.println("Error: " + ex.getMessage());
        System.exit(1);
        return null;
         }
    }
}

