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

    public static ProyectoDaoImpl ProyectoDao = new ProyectoDaoImpl();
    public static Proyecto proyecto;

    public static Tarea tarea;
    public static Persona persona;
    public static String resultado = "";
    
    public static void main(String[] args) {
        
        //ProyectoDaoImpl pro = new ProyectoDaoImpl();
        //Proyecto proyecto = new Proyecto("Proyecto Hibernate", "Primer Inser desde Hibernate");
        
        //int id = pro.create(proyecto);
        TareasHoy();
        //TareasProyectos();
        //System.out.println(pro.findById(id).getNombre()); 
        System.exit(0);
    }
    
    public static void TareasHoy(){
       List tareas = TareaDao.getTareaHoy();
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
            Proyecto pro = tarea.getProyecto();
            resultado += "Proyecto : " + pro.getNombre() + "\n";
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
        try{
          List<?> proyectos = ProyectoDao.getProyectos();
        for(Iterator iter = ProyectoDao.getProyectos().iterator(); iter.hasNext();){
            Object[] pr =  (Object[]) iter.next();
            for(int i= 0 ; i<pr.length ; i++){
              Proyecto p = (Proyecto) pr[0];
              Tarea t = (Tarea) pr[1];
              System.out.println(p.getNombre());
              System.out.println(t.getDescripcion());
            }
           
        }
       
        resultado = "";
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        
        for(Iterator iterator = proyectos.iterator(); iterator.hasNext();){
            Proyecto proy =  (Proyecto) iterator.next();
            resultado += "Proyecto \n";
            resultado += "Nombre: " + proy.getNombre() + "\n";
            /*resultado += "Descripción: " + proy.getDescripcion() + "\n";
           Tarea tar = (Tarea) proy.getTareas();
            resultado += "Tarea: " + tar.getNombre() + "\n";
            resultado += "Descripcioón: " + tar.getDescripcion() + "\n";
            resultado += "Fecha: " + df.format(tar.getFecha()) + "\n";*/
        }
        System.out.println(resultado);
        }catch(ClassCastException e)
        {
            System.out.println(e.getMessage());
        }
    }
    

}