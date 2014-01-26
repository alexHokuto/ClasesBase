/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clasesbase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author usuario
 */
public class Fecha {
    
        public static String DDMMYYYY= "dd/MM/yyyy";
        public static String DDMMYYYY_= "dd-MM-yyyy";
        public static String YYYYMMDD= "yyyy/MM/dd";
        public static String YYYYMMDD_= "yyyy-MM-dd";
        public static String NOMBRE_MES= "MMMM";
        public static String NOMBRE_MES_CORTO= "MMM";
        public static String MES_DEL_ANIO= "MM";
        public static String NOMBRE_DIA= "EEEE";
        public static String NOMBRE_DIA_CORTO= "EEE";
        public static String DIA_DEL_ANIO_D= "D";
        public static String DIA_DEL_ANIO_DDD= "DDD";
        public static String DIA_DEL_MES_D= "d";
        public static String DIA_DEL_MES_DD= "d";
    
        
    	public static long NUMERO_BASE_RELOJ = 60; // numero base usado en reloj
	public static long NUMERO_BASE_MILISEGUNDOS = 1000; // numero base usado en

	public static int FECHA_INICIO_ACTIVIDADES = 1;
	public static int FECHA_FIN_ACTIVIDADES = 2;

static Date fechaActual(){
    Date d= new Date();
    return d;
}

static String fechaActual(int pattern){
//    DateFormat.FULL= 0        domingo 26 de enero de 2014
//    DateFormat.LONG= 1        26 de enero de 2014
//    DateFormat.MEDIUM=2       26-ene-2014
//    DateFormat.SHORT=3        26/01/14
    Date d= new Date();
    DateFormat df1 = DateFormat.getDateInstance(pattern); 
    return df1.format(d);   
}   

static String fechaActual(String pattern){
    Date d= new Date();
    SimpleDateFormat formatoDeFecha = new SimpleDateFormat(pattern);
    return formatoDeFecha.format(d);   
}  

static String obtenerFecha(Date d, String pattern){
    SimpleDateFormat formatoDeFecha = new SimpleDateFormat(pattern);
    return formatoDeFecha.format(d);
}

static String obtenerFecha(Date d, int pattern){
    DateFormat df1 = DateFormat.getDateInstance(pattern);
    return df1.format(d);
}

static Date obtenerFecha(int dia, int mes, int anio){
    String fecha= String.valueOf(dia)+ "/" + String.valueOf(mes)+ "/" + String.valueOf(anio);
    return stringToDate(fecha, Fecha.DDMMYYYY);
}

static Date stringToDate(String strFecha, String pattern){
    SimpleDateFormat formatoDelTexto = new SimpleDateFormat(pattern);
    Date fecha = null;
    try {
        fecha = formatoDelTexto.parse(strFecha);
    } catch (ParseException ex) {
        ex.printStackTrace();
    }
    return fecha;
}   

static int getDiasXAnio(Date fecha){
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        if(cal.get(Calendar.YEAR)%4==0)
            return 366;
        else
            return 365; 
}

static int getDiasXAnio(String fecha, String pattern){
        Date d= stringToDate(fecha, pattern);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        if(cal.get(Calendar.YEAR)%4==0)
            return 366;
        else
            return 365;
}

static String[] arrayNombreDeMeses(){
    String [] nombreMeses = new java.text.DateFormatSymbols(new java.util.Locale("ES")) .getMonths();
    return nombreMeses;
}

static String[] arrayNombreDeDias(){
    String [] nombreDias = new java.text.DateFormatSymbols(new java.util.Locale("ES")) .getWeekdays();
    return nombreDias;
}

public static int cantidadDiasXNumMes(int mes, int ano) {
        int cantidadDias = 0;
                if (mes == 1)
                        return 31;
                if (mes == 2)
                        if (ano % 4 == 0)
                                return 29;
                        else
                                return 28;
                if (mes == 3)
                        return 31;
                if (mes == 4)
                        return 30;
                if (mes == 5)
                        return 31;
                if (mes == 6)
                        return 30;
                if (mes == 7)
                        return 31;
                if (mes == 8)
                        return 31;
                if (mes == 9)
                        return 30;
                if (mes == 10)
                        return 31;
                if (mes == 11)
                        return 30;
                if (mes == 12)
                        return 31;
   
        return cantidadDias;
}

static Date sumarCantDiasAFecha(Date fecha,int numDias){

      try{
              GregorianCalendar c = new GregorianCalendar();
              c.setTime(fecha);
              c.add(Calendar.DAY_OF_MONTH,numDias);
              return c.getTime();
      }
    catch(Exception e){
            return null;
    }
}

static Date sumarCantDiasAFecha(String strFecha, String pattern, int numDias){

      try{
              Date fecha= Fecha.stringToDate(strFecha, pattern);
              GregorianCalendar c = new GregorianCalendar();
              c.setTime(fecha);
              c.add(Calendar.DAY_OF_MONTH,numDias);
              return c.getTime();
      }
    catch(Exception e){
            return null;
    }
}

static Date restarCantDiasAFecha(Date fecha,int numDias){

      try{
              numDias = numDias * (-1);
              GregorianCalendar c = new GregorianCalendar();
              c.setTime(fecha);
              c.add(Calendar.DAY_OF_MONTH,numDias);
              return c.getTime();
      }
    catch(Exception e){
            return null;
    }
}

static Date restarCantDiasAFecha(String strFecha, String pattern, int numDias){

      try{
              Date fecha= Fecha.stringToDate(strFecha, pattern);
              numDias = numDias * (-1);
              GregorianCalendar c = new GregorianCalendar();
              c.setTime(fecha);
              c.add(Calendar.DAY_OF_MONTH,numDias);
              return c.getTime();
      }
    catch(Exception e){
            return null;
    }
}

static Date getDateXDiadelAnio(int dia, int anio){
        try{
              String strFecha= "0101" + String.valueOf(anio);
              Date date_inicio = Fecha.stringToDate( strFecha, "ddMMyyyy");
              return Fecha.sumarCantDiasAFecha(date_inicio, dia);
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
    }
}

static int compareFechasDate(Date fecha1, Date fecha2){
    int resultado=0;
    if (fecha1.compareTo(fecha2) == 0)
        resultado = 0;
    else if (fecha1.compareTo(fecha2) >0)    
        resultado = 1;
    if (fecha1.compareTo(fecha2) < 0)   
        resultado = -1;
    
    return resultado;
}

static int compareFechasDate(String strFechaUno, String strFechaDos, String pattern){
    
    int resultado=0;
    Date fecha1 = Fecha.stringToDate( strFechaUno, pattern);
    Date fecha2 = Fecha.stringToDate( strFechaDos, pattern);
    if (fecha1.compareTo(fecha2) == 0)
        resultado = 0;
    else if (fecha1.compareTo(fecha2) >0)    
        resultado = 1;
    if (fecha1.compareTo(fecha2) < 0)   
        resultado = -1;
    
    return resultado;
}

static long getCantidadDeDiasEntreFechas(Date fechaMayor, Date fechaMenor){

    try{
            final long MS_IN_A_DAY = 3600*24*1000;      //1000*60*60*24;
            java.util.Date date1 = fechaMayor;
            java.util.Date date2 = fechaMenor;
            long diff = date1.getTime() - date2.getTime();
            long numDays = diff/MS_IN_A_DAY;

            return numDays;
    }
    catch(Exception e){
        e.printStackTrace();
     return 0;
    }
}	

static String formateaFechaSAP(Date fecha) {
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String fechaSap = dateFormat.format(fecha);
    return fechaSap;
}

static String formateaFechaSAP(String strFecha, String pattern) {
    Date fecha= Fecha.stringToDate(strFecha, pattern);
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String fechaSap = dateFormat.format(fecha);
    return fechaSap;
}

static java.sql.Date getSqlDate(java.util.Date DateUtil){
    java.sql.Date dsql= new java.sql.Date(DateUtil.getTime());
    return dsql;
}


public static void main(String argv[]) {
    
    try {
//        for (int i = 0; i < 4; i++) {
//            System.out.println("Fecha Actual: " + Fecha.fechaActual(i));
//        }

//        System.out.println("dd/MM/yyyy: " + Fecha.fechaActual(Fecha.DDMMYYYY));
//        System.out.println("dd-MM-yyyy: " + Fecha.fechaActual(Fecha.DDMMYYYY_));
//        System.out.println("yyyy/MM/dd: " + Fecha.fechaActual(Fecha.YYYYMMDD));
//        System.out.println("yyyy-MM-dd: " + Fecha.fechaActual(Fecha.YYYYMMDD_));
//        System.out.println("Nombre Mes: " + Fecha.fechaActual(Fecha.NOMBRE_MES));
//        System.out.println("Nombre Mes Corto: " + Fecha.fechaActual(Fecha.NOMBRE_MES_CORTO));
//        System.out.println("Index Mes del año: " + Fecha.fechaActual(Fecha.MES_DEL_ANIO));
//        System.out.println("Nombre del día: " + Fecha.fechaActual(Fecha.NOMBRE_DIA));
//        System.out.println("Nombre del día corto: " + Fecha.fechaActual(Fecha.NOMBRE_DIA_CORTO));
//        System.out.println("Día del año d: " + Fecha.fechaActual(Fecha.DIA_DEL_ANIO_D));
//        System.out.println("Día del año dd: " + Fecha.fechaActual(Fecha.DIA_DEL_ANIO_DDD));
//        System.out.println("Día del mes d: " + Fecha.fechaActual(Fecha.DIA_DEL_MES_D));
//        System.out.println("Día del mes dd: " + Fecha.fechaActual(Fecha.DIA_DEL_MES_DD));
        
//        System.out.println("Obtener Fecha: " + Fecha.obtenerFecha(new Date(), Fecha.DDMMYYYY_));
//        System.out.println("Obtener Fecha: " + Fecha.obtenerFecha(26, 1, 2013));
//        System.out.println("Obtener Fecha: " + Fecha.stringToDate("26/01/2014", Fecha.DDMMYYYY));
//        System.out.println("Obtener Fecha Español: " + Fecha.obtenerFecha(Fecha.stringToDate("26/01/2014", Fecha.DDMMYYYY), 0));
        
//        System.out.println("Cantidad de días por año: " + Fecha.getDiasXAnio(new Date()));
//        System.out.println("Cantidad de días por año: " + Fecha.getDiasXAnio("01052012","ddMMyyyy"));
        
//          String[] arrayNombreDeMeses= Fecha.arrayNombreDeMeses();
//          for (int i = 0; i < arrayNombreDeMeses.length-1; i++) {
//              System.out.println("Mes (" + i + ") : " + arrayNombreDeMeses[i]);
//          }
        
//          String[] arrayNombreDias= Fecha.arrayNombreDeDias();
//          for (int i = 1; i < arrayNombreDias.length; i++) {
//              System.out.println("Día (" + i + ") : " + arrayNombreDias[i]);
//          }
//          System.out.println("SumarNumeroDiasAFecha: " + Fecha.sumarCantDiasAFecha(new Date(), 20));
//          System.out.println("SumarNumeroDiasAFecha: " + Fecha.restarCantDiasAFecha(new Date(), 20));
//          System.out.println("SumarNumeroDiasAFecha: " + Fecha.sumarCantDiasAFecha("01-01-2014", Fecha.DDMMYYYY_ , 20));
//          System.out.println("SumarNumeroDiasAFecha: " + Fecha.restarCantDiasAFecha("01-01-2014", Fecha.DDMMYYYY_ , 20));
        
//            System.out.println("Date por día del Año: " + Fecha.getDateXDiadelAnio(5, 2014));
        
            Date fechaUno= new Date();
            Date fechaDos= Fecha.restarCantDiasAFecha(fechaUno, 10);
//            System.out.println("Compara: " + Fecha.compareFechasDate(fechaUno, fechaDos));
//            System.out.println("Compara: " + Fecha.compareFechasDate("11-01-2014", "01-01-2014", Fecha.DDMMYYYY_));
//            System.out.println("Diferencia de días entre Fechas: " + Fecha.getCantidadDeDiasEntreFechas(fechaUno, fechaDos));

            System.out.println("Fecha SAP: " + Fecha.formateaFechaSAP("21-11-2012", DDMMYYYY_));
        
    } catch (Exception e) {
            e.printStackTrace();
    }
}
}
