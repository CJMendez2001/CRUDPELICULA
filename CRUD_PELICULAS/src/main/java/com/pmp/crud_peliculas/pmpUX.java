/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.crud_peliculas;

import java.util.Scanner;


/**
 *
 * @author mende
 */
public class pmpUX {
    
    public static void separator(){
        System.out.println("====================");
    }
    public static void header(String title){
        separator();
        System.out.println(title);
        separator();
    }
    public static void generateMenu(){
        header("Opciones de Menu");
        System.out.println("( M ) \t Mostrar todos.");
        System.out.println("( N ) \t Nuevo.");
        System.out.println("( A ) \t Actualizar uno.");
        System.out.println("( E ) \t Eliminar uno.");
        separator();
        System.out.println("( S ) \t Salir");
        separator();
        System.out.println("Escriba una opción y presione enter para continuar:");
    }
    public static String getFieldInput(Scanner input, String label, String defaultValue){
    System.out.println(label + " (" + defaultValue + ") : \t");
    String inputValue = input.nextLine();
    if (inputValue.isBlank()){
        return defaultValue;
        }
        return inputValue.strip();
    }
}
