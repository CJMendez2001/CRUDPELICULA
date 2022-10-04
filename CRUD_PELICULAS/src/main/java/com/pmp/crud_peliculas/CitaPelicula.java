/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.crud_peliculas;

/**
 *
 * @author mende
 */
public class CitaPelicula {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombrePelicula() {
        return NombrePelicula;
    }

    public void setNombrePelicula(String NombrePelicula) {
        this.NombrePelicula = NombrePelicula;
    }

    public String getGeneroPelicula() {
        return GeneroPelicula;
    }

    public void setGeneroPelicula(String GeneroPelicula) {
        this.GeneroPelicula = GeneroPelicula;
    }

    public String getDirectorPelicula() {
        return DirectorPelicula;
    }

    public void setDirectorPelicula(String DirectorPelicula) {
        this.DirectorPelicula = DirectorPelicula;
    }

    public String getClasificacionPelicula() {
        return ClasificacionPelicula;
    }

    public void setClasificacionPelicula(String ClasificacionPelicula) {
        this.ClasificacionPelicula = ClasificacionPelicula;
    }

    public Integer getYearPelicula() {
        return YearPelicula;
    }

    public void setYearPelicula(Integer YearPelicula) {
        this.YearPelicula = YearPelicula;
    }

    private String NombrePelicula;
    private String GeneroPelicula;
    private String DirectorPelicula;
    private String ClasificacionPelicula;
    private Integer YearPelicula;
    private Integer id; 
}
