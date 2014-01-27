/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coleccion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ObjectSortingExample {
    
    static void mostrarList(List<Order> lstOrder){
        for (Order order : lstOrder) {
            System.out.println("orderId:" + order.getOrderId() + ": amount:" + order.getAmount() + ": customer:" + order.getCustomer());
        }
    }
    
    public static void main(String args[]) {
      
        //Creating Order object to demonstrate Sorting of Object in Java
        Order ord1 = new Order(101,2000, "Sony");
        Order ord2 = new Order(102,4000, "Hitachi");
        Order ord3 = new Order(103,6000, "Philips");
      
        //putting Objects into Collection to sort
        List<Order> lstOrders = new ArrayList<Order>();
        lstOrders.add(ord3);
        lstOrders.add(ord1);
        lstOrders.add(ord2);
      
        //printing unsorted collection
        System.out.println("********  Muestra Collection ************");
        mostrarList(lstOrders);
        
        //Sorting Order Object on natural order - ascending
        System.out.println("********  Ordena Collection ************");
        Collections.sort(lstOrders);
        mostrarList(lstOrders);

      
        // Sorting object in descending order in Java
        System.out.println("********  Ordena Desc Collection ************");
        Collections.sort(lstOrders, Collections.reverseOrder());
        mostrarList(lstOrders);
              
        //Sorting object using Comparator in Java
        System.out.println("********  Ordena ByAmount Collection ************");
        Collections.sort(lstOrders, new Order.OrderByAmount());
        mostrarList(lstOrders);
      
        // Comparator sorting Example - Sorting based on customer
        System.out.println("********  Ordena ByCustomer Collection ************");
        Collections.sort(lstOrders, new Order.OrderByCustomer());
        mostrarList(lstOrders);
    }
}
