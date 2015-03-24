/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.vista;

import com.agenda.dao.ProyectoDaoImpl;
import com.agenda.dao.PersonaDaoImpl;
import com.agenda.dao.TareaDaoImpl;
import com.agenda.model.Proyecto;
import com.agenda.model.Persona;
import com.agenda.model.Tarea;
import java.text.DateFormat;
import java.util.*;


public class Main {

    public static TareaDaoImpl TareaDao = new TareaDaoImpl();
    public static PersonaDaoImpl PersonaDao = new PersonaDaoImpl();
    public static Tarea tarea;
    public static Persona persona;
    public static String resultado = "";
    
    public static void main(String[] args) {
        
        ProyectoDaoImpl pro = new ProyectoDaoImpl();
        Proyecto proyecto = new Proyecto("Proyecto Hibernate", "Primer Inser desde Hibernate");
        
        int id = pro.create(proyecto);
        System.out.println(pro.findById(id).getNombre());   
    }
    
    public static void TareasHoy(){
        List<Tarea> list;
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        list = TareaDao.getTareaHoy();
        
        resultado = "";
        for (Tarea tarea1 : list){
        resultado += "Nombre: " + tarea1.getNombre() + "\n";
        resultado += "Descripción: " + tarea1.getDescripcion() + "\n";
        resultado += "Fecha: " + df.format(tarea1.getFecha()) + "\n";
        resultado += "Estado: " + tarea1.isEstadoTarea() + "\n";
        //resultado += "Persona: " + tarea1.getPersonaId() + "\n";
        //resultado += "Proyecto: " + tarea1.getProyectoId() + "\n\n";
        }
        System.out.println(resultado);
    }
    
    public static void Insert(){
        Integer id;
        java.util.Date fecha =  new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        Persona persona = new Persona("Pepito", "Perez", "pepitoP@gmail.com");
        Proyecto proyecto = new Proyecto("Integrador","Programación IV");
        
        tarea = new Tarea("Hibernate", "Realizar el ejercicio de hibernate", fecha, 1, true, persona, proyecto);
        id = TareaDao.create(tarea);
        
        tarea = TareaDao.findById(id);
        
        resultado = "";
        resultado += "Nombre: " + tarea.getNombre() + "\n";
        resultado += "Descripción: " + tarea.getDescripcion() + "\n";
        resultado += "Fecha: " + df.format(tarea.getFecha()) + "\n";
        resultado += "Estado: " + tarea.isEstadoTarea() + "\n";
        resultado += "Persona: " + tarea.getPersonaId() + "\n";
        resultado += "Proyecto: " + tarea.getProyectoId() + "\n\n";
        
        System.out.println("Guardado con exito! \n" + resultado);
    }
    
    public static void Update(Integer idTarea){
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        tarea = TareaDao.findById(idTarea);
        
        tarea.setNombre("Hibernate JSF");
        TareaDao.update(tarea);
        
        resultado = "";
        resultado += "Nombre: " + tarea.getNombre() + "\n";
        resultado += "Descripción: " + tarea.getDescripcion() + "\n";
        resultado += "Fecha: " + df.format(tarea.getFecha()) + "\n";
        resultado += "Estado: " + tarea.isEstadoTarea() + "\n"; 
        resultado += "Persona: " + tarea.getPersonaId() + "\n";
        resultado += "Proyecto: " + tarea.getProyectoId() + "\n\n";
        
        System.out.println("Actualizado con exito! \n" + resultado);
    }
    
    public static void Delete(Integer idTarea){
        System.out.println("Elementos: " + TareaDao.getCountOfAll() + "\n\n");
        
        tarea = TareaDao.findById(idTarea);
        TareaDao.delete(tarea);
        
        System.out.println("Elementos restantes: " + TareaDao.getCountOfAll() + "\n\n");
    }
    
    public static void TraerTodas(){
        List<Tarea> list;
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        
        list = TareaDao.findAll();
        resultado = "";
        
        for (Tarea tarea1 : list){
        resultado += "Nombre: " + tarea1.getNombre() + "\n";
        resultado += "Descripción: " + tarea1.getDescripcion() + "\n";
        resultado += "Fecha: " + df.format(tarea1.getFecha()) + "\n";
        resultado += "Estado: " + tarea1.isEstadoTarea() + "\n";
        //resultado += "Persona: " + tarea1.getPersonaId() + "\n";
        //resultado += "Proyecto: " + tarea1.getProyectoId() + "\n\n";
        }
        
        System.out.println(resultado);
    }
    
    public static void TareasPendientes(){
        List tareas = TareaDao.getPendientes();
        resultado = "";
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        
        for (Iterator iterator = tareas.iterator(); iterator.hasNext();){
            Tarea tarea = (Tarea) iterator.next();
            resultado += "Tarea \n";
            resultado += "Nombre: " + tarea.getNombre() + "\n";
            resultado += "Descripción: " + tarea.getDescripcion() + "\n";
            resultado += "Fecha: " + df.format(tarea.getFecha()) + "\n";
            Persona per = tarea.getPersona();
            resultado += "Responsable: " + per.getNombre() + per.getApellido() + "\n";
        }
        System.out.println(resultado);
    }
    
    public static void TareasProyectos(){
        List tareas = TareaDao.getProyectos();
        resultado = "";
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        
        for(Iterator iterator = tareas.iterator(); iterator.hasNext();){
            Tarea tarea = (Tarea) iterator.next();
            resultado += "Proyecto \n";
            Proyecto pro = tarea.getProyecto();
            resultado += "Nombre: " + pro.getNombre() + "\n";
            resultado += "Descripción: " + pro.getDescripcion() + "\n";
            resultado += "Tarea: " + tarea.getNombre() + "\n";
            resultado += "Descripcioón: " + tarea.getDescripcion() + "\n";
            resultado += "Fecha: " + df.format(tarea.getFecha()) + "\n";
        }
        System.out.println(resultado);
    }
    
}
