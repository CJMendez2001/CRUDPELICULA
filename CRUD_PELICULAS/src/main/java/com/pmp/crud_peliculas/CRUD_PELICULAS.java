/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.pmp.crud_peliculas;
import java.util.Scanner;
import java.util.ArrayList;
import com.pmp.crud_peliculas.dao.CitaPeliculaDao;
/**
 *
 * @author mende
 */
public class CRUD_PELICULAS {
    public static Scanner input;
    public static ArrayList<CitaPelicula> arrCitaPelicula;
    public static CitaPeliculaDao peliculaDao;
    
    public static void main(String[] args) {
        input = new Scanner(System.in);
        arrCitaPelicula = new ArrayList();
        
        peliculaDao = new CitaPeliculaDao();
        
        pmpUX.header("CRUD Peliculas");
        String optionSelected = "";
        while( !optionSelected.equalsIgnoreCase("S")){
            pmpUX.generateMenu();
            optionSelected = input.nextLine();
            mainController(optionSelected);
        }
    }
    
    public static void mainController(String optionSelected){
        arrCitaPelicula = peliculaDao.obtenerCitas();
        switch (optionSelected.toUpperCase()){
        case"M":
            mostrarCita();
            break;
        case"N":
            newCitaPelicula();
            break;    
        case"A":
            actualizarCita();
            break;    
        case"E":
            eliminarCita();
            break;    
        case"S":
            System.out.println("Opcion S Seleccionada");
            break;
        default:
            pmpUX.header("Opción no Válida");
        }
    }
    
    private static CitaPelicula inputForm(CitaPelicula baseCita){
       baseCita.setNombrePelicula(
   pmpUX.getFieldInput(input, "Nombre Pelicula", baseCita.getNombrePelicula())
        );
        baseCita.setGeneroPelicula(
   pmpUX.getFieldInput(input, "Genero Pelicula", baseCita.getGeneroPelicula())
        );
        baseCita.setDirectorPelicula(
   pmpUX.getFieldInput(input, "Director Pelicula", baseCita.getDirectorPelicula())
        );
        baseCita.setClasificacionPelicula(
   pmpUX.getFieldInput(input, "Clasificacion de edad Pelicula", baseCita.getClasificacionPelicula())
        );
        baseCita.setYearPelicula(
                Integer.parseInt(
                pmpUX.getFieldInput(input, "Año", baseCita.getYearPelicula().toString()))
        );
        System.out.println(baseCita.getNombrePelicula() + " " + baseCita.getGeneroPelicula()
        );
        return baseCita;
    }
    
    private static CitaPelicula validarEntradaRegistro(){
       if (arrCitaPelicula.isEmpty()){
            System.out.println("No Hay Datos!");
            return null;
        }
        int index = Integer.parseInt(
                pmpUX.getFieldInput(input, "Número de Linea: ", "1")
        );
        for (int i = 0; i < arrCitaPelicula.size(); i++ ){
            if (index == arrCitaPelicula.get(i).getId()){
            return arrCitaPelicula.get(i);
        }
        }
       // if (index >= 0  || index < arrCitaPelicula.size()) {
        //return index - 1;
        //}
        return null;
    }
            
    private static void newCitaPelicula(){
        CitaPelicula newCitaPelicula = new CitaPelicula();
        newCitaPelicula.setNombrePelicula("Progressive");
        newCitaPelicula.setGeneroPelicula("Fantasia");
        newCitaPelicula.setDirectorPelicula("Reki Kawahara");
        newCitaPelicula.setClasificacionPelicula("Mayores de 12");
        newCitaPelicula.setYearPelicula(2022);
        newCitaPelicula = inputForm(newCitaPelicula);
        peliculaDao.insertCita(newCitaPelicula);
        arrCitaPelicula.add(newCitaPelicula);
        
    }
    
    private static void mostrarCita(){
        arrCitaPelicula = peliculaDao.obtenerCitas();
     if (arrCitaPelicula.size() > 0){
         for(int i = 0; i < arrCitaPelicula.size(); i++){
            CitaPelicula cita = arrCitaPelicula.get(i);
            System.out.println(
                   String.valueOf(i+ 1) + "--" +
                   "\nNombre: " + arrCitaPelicula.get(i).getNombrePelicula() + 
                    "\nGenero: " + cita.getGeneroPelicula() + 
                    "\nDirector: " + cita.getDirectorPelicula() + 
                    "\nClasificacion: " + cita.getClasificacionPelicula() +  
                    "\nAño: " + cita.getYearPelicula().toString()
            );
            }
    }else {
         System.out.println("No hay datos que mostrar.");
        }
    }
 
    private static void actualizarCita(){
       
        CitaPelicula updateCitaPelicula = validarEntradaRegistro();
        if (updateCitaPelicula != null){
        updateCitaPelicula = inputForm(updateCitaPelicula);
        peliculaDao.updateCita(updateCitaPelicula);
        System.out.println("Registro Modificado");
        }
    }
    
    private static void eliminarCita(){
    CitaPelicula deleteCitaPelicula = validarEntradaRegistro();
    if (deleteCitaPelicula != null) {
        peliculaDao.deleteCita(deleteCitaPelicula);
        System.out.println("Registro Modificado");
    }
    }  
}
    
