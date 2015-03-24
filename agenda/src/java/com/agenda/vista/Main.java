/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.vista;

import com.agenda.dao.ProyectoDaoImpl;
import com.agenda.model.Proyecto;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ProyectoDaoImpl pro = new ProyectoDaoImpl();
        Proyecto proyecto = new Proyecto("Proyecto Hibernate", "Primer Inser desde Hibernate");
        
        int id = pro.create(proyecto);
        System.out.println(id);
        
    }
    
}
