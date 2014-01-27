/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coleccion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author LENOVO
 */
public class BeanObjetivo implements Serializable,Comparable {

    private static final long serialVersionUID = 1L;
    private String idEmpleado;
    private String periodo;
    private String idPilar;
    private String idObjetivo;
    private String descripcionIndice;
    private String descripcionObjetivo;
    private String valor;
    private String idVersion;
    private boolean modificable;
    
    
    public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
    
	public String getIdPilar() {
		return idPilar;
	}
	public void setIdPilar(String idPilar) {
		this.idPilar = idPilar;
	}
	public String getIdObjetivo() {
		return idObjetivo;
	}
	public void setIdObjetivo(String idObjetivo) {
		this.idObjetivo = idObjetivo;
	}
	public String getDescripcionIndice() {
		return descripcionIndice;
	}
	public void setDescripcionIndice(String descripcionIndice) {
		this.descripcionIndice = descripcionIndice;
	}
	public String getDescripcionObjetivo() {
		return descripcionObjetivo;
	}
	public void setDescripcionObjetivo(String descripcionObjetivo) {
		this.descripcionObjetivo = descripcionObjetivo;
	}
	public boolean isModificable() {
		return modificable;
	}
	public void setModificable(boolean modificable) {
		this.modificable = modificable;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	public String getIdVersion() {
		return idVersion;
	}
	public void setIdVersion(String idVersion) {
		this.idVersion = idVersion;
	}
	public int compareTo(Object o) {
		 BeanObjetivo beanObjetivo = (BeanObjetivo)o;        
	     return this.idObjetivo.compareToIgnoreCase(beanObjetivo.idObjetivo);                
	}

	
    public void pintar(){
    	
    	System.out.println("getIdEmpleado:" + this.getIdEmpleado());
    	System.out.println("getPeriodo:" + this.getPeriodo());
    	System.out.println("getIdPilar:" + this.getIdPilar());
    	System.out.println("getIdObjetivo:" + this.getIdObjetivo());
    	System.out.println("getDescripcionIndice:" + this.getDescripcionIndice());
    	System.out.println("getDescripcionObjetivo:" + this.getDescripcionObjetivo());
    	System.out.println("getValor:" +this.getValor());
    	System.out.println("getIdVersion:" + this.getIdVersion());
    	System.out.println("isModificable:" + this.isModificable());
    	System.out.println("getIdVersion:" + this.getIdVersion());
    }
    
    public static void main(String[] args) {
        List<BeanObjetivo> lstObjetivos = new ArrayList();
        BeanObjetivo beanObjetivo= new BeanObjetivo();
            beanObjetivo.setIdObjetivo("O1002");
            beanObjetivo.setDescripcionIndice("1.2");
        lstObjetivos.add(beanObjetivo);
        beanObjetivo= new BeanObjetivo();
            beanObjetivo.setIdObjetivo("O1001");
            beanObjetivo.setDescripcionIndice("1.1");
        lstObjetivos.add(beanObjetivo);
        beanObjetivo= new BeanObjetivo();
            beanObjetivo.setIdObjetivo("O1003");
            beanObjetivo.setDescripcionIndice("1.3");
         lstObjetivos.add(beanObjetivo);
         
        for (BeanObjetivo objetivo : lstObjetivos) {
            System.out.println("Id:" + objetivo.getIdObjetivo() + ": Indice:" + objetivo.getDescripcionIndice());
        }
    
        Collections.sort(lstObjetivos);	//Ordena Objetivos
        System.out.println("****** Ordenado ************");
         for (BeanObjetivo objetivo : lstObjetivos) {
            System.out.println("Id:" + objetivo.getIdObjetivo() + ": Indice:" + objetivo.getDescripcionIndice());
        }
    }
}
