/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.crud_peliculas.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.Exception;
import java.util.ArrayList;
import com.pmp.crud_peliculas.CitaPelicula;


 /*
 * @author mende
 */
public class CitaPeliculaDao {
    /*  NombrePelicula;
        GeneroPelicula;
        DirectorPelicula;
        ClasificacionPelicula;
        YearPelicula;
    */
    private Connection conn = null;
    public  CitaPeliculaDao() {
        try{
        conn = Conexion.getConnection();
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS CITAPELICULA ("
               + "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + "NombrePelicula TEXT , "
                    + "GeneroPelicula TEXT , "
                    + "DirectorPelicula TEXT , " 
                    + "ClasificacionPelicula TEXT , " 
                    + "YearPelicula INTEGER"
                    + ");";
        Statement comandoSQLCreate = conn.createStatement();
        comandoSQLCreate.executeUpdate(sqlCreateTable);
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }
    
    public void insertCita(CitaPelicula newCita){
        try {
    String sqlInsert = "INSERT INTO CITAPELICULA(NombrePelicula,GeneroPelicula," + 
            "DirectorPelicula, ClasificacionPelicula, YearPelicula) values ("+
            "?, ? ,? , ?, ?)";
            
         PreparedStatement comandoInsert = conn.prepareStatement(sqlInsert);
         
         comandoInsert.setString(1, newCita.getNombrePelicula());
         comandoInsert.setString(2, newCita.getGeneroPelicula());
         comandoInsert.setString(3, newCita.getDirectorPelicula());
         comandoInsert.setString(4, newCita.getClasificacionPelicula());
         comandoInsert.setInt(5, newCita.getYearPelicula());
         //comandoInsert.setString(4, newCita.getYearPelicula().toString());
         
         int registroAgregados = comandoInsert.executeUpdate();
         System.out.println(registroAgregados);
        }catch (Exception ex){
        System.err.println(ex.getMessage());
        }
    }
    
    public void updateCita(CitaPelicula updateCita){
    try{
       String sqlStrUpdate  = "UPDATE CITAPELICULA set NombrePelicula = ?," +
                            " GeneroPelicula = ?, " +
                            " DirectorPelicula = ?," +
                            " ClasificacionPelicula = ?, " +
                            " YearPelicula = ? where id = ?;";
       PreparedStatement comando = this.conn.prepareStatement(sqlStrUpdate);
       comando.setString(1, updateCita.getNombrePelicula());
       comando.setString(2, updateCita.getGeneroPelicula());
       comando.setString(3, updateCita.getDirectorPelicula());
       comando.setString(4, updateCita.getClasificacionPelicula());
       comando.setInt(5, updateCita.getYearPelicula());
       comando.setInt(6, updateCita.getId());
       comando.executeUpdate();
       comando.close();
    }catch (Exception ex){
        System.err.println(ex.getMessage());
        }
    }
    
    public void deleteCita(CitaPelicula deleteCita){
    try{
       String sqlStrDelete  = "DELETE from CITAPELICULA where id = ?;";
       PreparedStatement comando = this.conn.prepareStatement(sqlStrDelete);
       comando.setInt(1, deleteCita.getId());
       comando.executeUpdate();
       comando.close();
    }catch (Exception ex){
        System.err.println(ex.getMessage());
        }
    }
    
    
    public ArrayList<CitaPelicula> obtenerCitas(){
        try{
            String sqlstr = "SELECT * from CITAPELICULA;";
            Statement comando = conn.createStatement();
            ArrayList citas = new ArrayList <CitaPelicula>();
            ResultSet registros = comando.executeQuery(sqlstr);
            while (registros.next()){
              CitaPelicula citaPelicula = new CitaPelicula();
              citaPelicula.setId(registros.getInt("id"));
              citaPelicula.setNombrePelicula(registros.getString("NombrePelicula"));
              citaPelicula.setGeneroPelicula(registros.getString("GeneroPelicula"));
              citaPelicula.setDirectorPelicula(registros.getString("DirectorPelicula"));
              citaPelicula.setClasificacionPelicula(registros.getString("ClasificacionPelicula"));
              citaPelicula.setYearPelicula(registros.getInt("YearPelicula"));
              citas.add(citaPelicula);
            }
            return citas;
        } catch (Exception ex){
            System.err.println(ex.getMessage());
            return new ArrayList <CitaPelicula>();
        }
    }
}
