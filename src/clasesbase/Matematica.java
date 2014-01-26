/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clasesbase;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author usuario
 */
public class Matematica {
    
    static double generarRandomDouble(int num){
        Random rndNumbers = new Random(num);
        double rndNumber = rndNumbers.nextGaussian() * 1000;
        String pattern = "######.##";
        DecimalFormat f = new DecimalFormat(pattern, new DecimalFormatSymbols(Locale.US));
        String cadena= f.format(rndNumber);
        double montoFinal=Double.valueOf(cadena);
        return montoFinal;
    }
    
    static int generarRandomInteger(int num){
        Random rndNumbers = new Random(num);
        double rndNumber = rndNumbers.nextGaussian() * 1000;
        int numeroFinal= (int) rndNumber;
        return numeroFinal;
    }

   static String customFormat(String pattern, double value) {
    DecimalFormat myFormatter = new DecimalFormat(pattern,  new DecimalFormatSymbols(Locale.US));
    String output = myFormatter.format(value);
    return output;
  }
   
   static String customFormat(String pattern, int value) {
    DecimalFormat myFormatter = new DecimalFormat(pattern,  new DecimalFormatSymbols(Locale.US));
    String output = myFormatter.format(value);
    return output;
  }
    
    public void mostrarRandonDouble(String pattern){
        for (int i = 0; i < 3; i++) {
            double randomDouble= generarRandomDouble(i+999);
            System.out.println("randomDouble: " + randomDouble + "  Formato:" + customFormat(pattern, randomDouble));
        }
    }
    public void mostrarRandonInteger(String pattern){
        for (int i = 0; i < 3; i++) {
            int randomInteger= this.generarRandomInteger(i+999);
            System.out.println("randomInteger: " + randomInteger + "  Formato:" + customFormat(pattern, randomInteger) );
        }
    }
    
    static BigDecimal sumarBigDecimal(double num1, double num2, int precisionDecimal){
        // create MathContext object with 4 precision
//        MathContext mc = new MathContext(4);
        BigDecimal numUno= new BigDecimal(num1);
        BigDecimal sumar;
        sumar= numUno.add(new BigDecimal(num2));
        return sumar.setScale(precisionDecimal, RoundingMode.HALF_UP);
    }
    
    static BigDecimal restarBigDecimal(double num1, double num2, int precisionDecimal){
        BigDecimal numUno= new BigDecimal(num1);
        BigDecimal restar;
        restar= numUno.subtract(new BigDecimal(num2));
        return restar.setScale(precisionDecimal, RoundingMode.HALF_UP);
    }
    
    static BigDecimal multiplicarBigDecimal(double num1, double num2, int precisionDecimal){
        BigDecimal numUno= new BigDecimal(num1);
        BigDecimal multiplicar;
        multiplicar= numUno.multiply(new BigDecimal(num2));
        return multiplicar.setScale(precisionDecimal, RoundingMode.HALF_UP);
    }
    
    static BigDecimal dividirBigDecimal(double num1, double num2, int precisionDecimal){
        BigDecimal numUno= new BigDecimal(num1);
        BigDecimal dividir;
        dividir= numUno.divide(new BigDecimal(num2), precisionDecimal, RoundingMode.HALF_UP);
        return dividir; 
    }
    
    public static void main(String[] args) {
        Matematica matematica= new Matematica();
        String patternUno= "###,###.####";
        String patternDos= "000000.00000";
        matematica.mostrarRandonDouble(patternUno);
        matematica.mostrarRandonInteger(patternDos);
        String sumarBigDecimal= Matematica.sumarBigDecimal(1040.739, 30.12, 5).toString();
        System.out.println("Sumar BigDecimal: " + sumarBigDecimal);
        double sumar= Matematica.sumarBigDecimal(1040.739, 30.12, 5).doubleValue();    
        System.out.println(patternUno + " " + Matematica.customFormat(patternUno, sumar)); 
        System.out.println(patternDos + " " + Matematica.customFormat(patternDos, sumar)); 
        String restarBigDecimal= Matematica.restarBigDecimal(40.75, 30.121, 4).toString();
        System.out.println("Sumar BigDecimal: " + restarBigDecimal);
        double multiplicar= Matematica.multiplicarBigDecimal(140.739, 30.12, 5).doubleValue(); 
        System.out.println("Multiplicar " + patternUno + " " + Matematica.customFormat(patternUno, multiplicar)); 
        double dividir= Matematica.dividirBigDecimal(1540.739, 3.12, 5).doubleValue(); 
        System.out.println(dividir);
        System.out.println("Dividir " + patternUno + " " + Matematica.customFormat(patternUno, dividir)); 
        
    }
    
   
}
