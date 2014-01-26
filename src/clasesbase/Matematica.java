/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clasesbase;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author usuario
 */
public class Matematica {
    
    private double generarRandomDouble(int num){
        
        Random rndNumbers = new Random(num);
        double rndNumber = rndNumbers.nextGaussian() * 1000;
        String pattern = "######.##";
        DecimalFormat f = new DecimalFormat(pattern, new DecimalFormatSymbols(Locale.US));
        String cadena= f.format(rndNumber);
        double montoFinal=Double.valueOf(cadena);
        return montoFinal;
    }
    
    private int generarRandomInteger(int num){
        
        Random rndNumbers = new Random(num);
        double rndNumber = rndNumbers.nextGaussian() * 1000;
        int numeroFinal= (int) rndNumber;
       
        return numeroFinal;
    }
    
    private String doubleAFormatear(double monto){
        String pattern = "###,###.##";
        DecimalFormat f = new DecimalFormat(pattern, new DecimalFormatSymbols(Locale.US));
        String cadena= f.format(monto);
        return cadena;
    }
    
    private String integerAFormatear(int monto){
        String pattern = "###,###";
        DecimalFormat f = new DecimalFormat(pattern, new DecimalFormatSymbols(Locale.US));
        String cadena= f.format(monto);
        return cadena;
    }
    
    public void mostrarRandonDouble(){
        for (int i = 0; i < 3; i++) {
            double randomDouble= this.generarRandomDouble(i+999);
            System.out.println("randomDouble: " + randomDouble + "  Formato:" + this.doubleAFormatear(randomDouble));
        }
    }
    public void mostrarRandonInteger(){
        for (int i = 0; i < 3; i++) {
            int randomInteger= this.generarRandomInteger(i+999);
            System.out.println("randomInteger: " + randomInteger + "  Formato:" + this.integerAFormatear(randomInteger) );
        }
    }
    
    public static void main(String[] args) {
        Matematica matematica= new Matematica();
//        matematica.mostrarRandonDouble();
        matematica.mostrarRandonInteger();
//        matematica.claseMath();
        
        
        
    }
    
    private void claseMath(){
        System.out.println("****************** CLASE MATH ************************+");
        System.out.print( "2+3 es ");
        System.out.println( 2+3 );
        System.out.print( "2*3 es ");
        System.out.println( 2*3 );
        System.out.print( "2-3 es ");
        System.out.println( 2-3 );
        System.out.print( "3/2 es ");
        System.out.println( 3/2 );
        System.out.print( "3,0/2 es ");
        System.out.println( 3.0/2 );
        System.out.print( "El resto de dividir 13 entre 4 es ");
        System.out.println( 13%4 );
 
        System.out.print( "Un número al azar entre 0 y 1: ");
        System.out.println( Math.random() );
        System.out.print( "Un número al azar entre 50 y 150: ");
        System.out.println( (int)(Math.random()*100+50) );
        System.out.print( "Una letra minúscula al azar: ");
        System.out.println( (char)(Math.random()*26+'a') );
 
        System.out.print( "Coseno de PI radianes: ");
        System.out.println( Math.cos(Math.PI) );
        System.out.print( "Seno de 45 grados: ");
        System.out.println( Math.sin(Math.toRadians(45)) );
        System.out.print( "Arco cuya tangente es 1: ");
        System.out.println( Math.toDegrees(Math.atan(1)) );
 
        System.out.print( "Raíz cuadrada de 36: ") ;
        System.out.println( Math.sqrt(36) ) ;
        System.out.print( "Cinco elevado al cubo: "); 
        System.out.println( Math.pow(5.0,3.0) ) ;
        System.out.print( "Exponencial de 2: ") ;
        System.out.println( Math.exp(2) ) ;
        System.out.print( "Logaritmo de 2,71828: "); 
        System.out.println( Math.log(2.71828) );
 
        System.out.print( "Mayor valor entre 2 y 3: ");
        System.out.println( Math.max(2,3) );
        System.out.print( "Valor absoluto de -4,5: ");
        System.out.println( Math.abs(-4.5) );
        System.out.print( "Menor entero más cercano a -4,5: ");
        System.out.println( Math.floor(-4.5) );
        System.out.print( "Mayor entero más cercano a -4,5: ");
        System.out.println( Math.ceil(-4.5) );
        System.out.print( "Redondeando -4,5 con ROUND: ");
        System.out.println( Math.round(-4.5) );
        System.out.print( "Redondeando 4,5 con ROUND: ");
        System.out.println( Math.round(4.5) );
        System.out.print( "Redondeando -4,6 con RINT: ");
        System.out.println( Math.rint(-4.6) );
        System.out.print( "Redondeando -4,5 con RINT: ");
        System.out.println( Math.rint(4.5) );
    }
}
