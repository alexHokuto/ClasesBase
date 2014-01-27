/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clasesbase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Cadena {
    
    
    
 
    
 static List<String> cortarPalabras (String texto, int cantidadDeLetras){
        List<String> lstFinal= new ArrayList<String>();
        StringBuilder builder= new StringBuilder();

        if(texto.split(" ").length > 0){
            String[] arrayAux = texto.split(" ");
            List<String> lstPalabras= Arrays.asList(arrayAux);
            List<String> lstAuxiliar= new ArrayList<String>();
            int cont=0; int sumadorLetras=0;
            for (String string : lstPalabras) {
                if(string.length()>cantidadDeLetras){
                        while (string.length()>cantidadDeLetras ) {                        
                                lstAuxiliar.add(string.substring(0, cantidadDeLetras));
                                string= string.substring(cantidadDeLetras, string.length());
                        }
                       if(string.length()>0 ){
                           lstAuxiliar.add(string.substring(0, string.length()) + " ");
                       }
                }else{
                    lstAuxiliar.add(string + " ");
                }
            }
               
            for (String string : lstAuxiliar) {
                sumadorLetras+= string.length();
                if(cont==0){
                    builder.append(string);
                    
                }else{
                    if(sumadorLetras > cantidadDeLetras){
                        lstFinal.add(builder.toString());
                        builder.delete(0, builder.length());
                        builder.append(string);
                        sumadorLetras= string.length();
                    }else{
                        builder.append(string);
                    }
                }
                cont++;
            }
            
            if (builder.length()>0) 
                lstFinal.add(builder.toString());
            
        }        
        return lstFinal;
    }
    
 static String unirPalabras(List<String> lstPalabras){
     StringBuilder stringBuilder= new StringBuilder();
     for (String string : lstPalabras) {
         stringBuilder.append(string);
     }
     return stringBuilder.toString();
 }
 
 
    public static void main(String[] args) {
        Cadena cadena= new Cadena();
        String strPrueba = "12345678901234567890123456789012345678901234567890123456789012345678901234567890Desarrollo12345678901234567890123456789012345678901234567890123456789012345678901234567890Desarrollo guiado por pruebas, o Test-driven development (TDD) es una práctica de programación que involucra otras dos prácticas: Escribir las pruebas primero (Test First Development) y Debes confirmar tu dirección electrónica antes de editar páginas. Por favor, establece y valida una dirección electrónica a través de tus preferencias de usuario.";
        List<String> lstPalabras= Cadena.cortarPalabras(strPrueba, 78);
        for (String string : lstPalabras) {
            System.out.println(string );
        }
         System.out.println(Cadena.unirPalabras(lstPalabras));
    }
}
