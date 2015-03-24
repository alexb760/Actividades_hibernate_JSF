/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.dao;

import java.util.*;
import com.agenda.model.Tarea;
import java.io.Serializable;
import org.hibernate.HibernateException;
import util.HibernateUtil;

/**
 *
 * @author Usuario
 */
public class TareaDaoImpl extends GenericDaoImpl<Tarea, Integer> implements TareaDao{
    
    public List <Tarea> getTareaHoy(){
        
        List <Tarea> list;
        try{
            java.util.Date fecha = new Date();
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            list = session.createQuery("from Tarea as ta where ta.fecha >= 2015-03-24").list();
            tx.commit();
        }catch(HibernateException e){
            list = null;
            tx.rollback();
            throw e;
        }
        return list;
    }
    
    public List<Tarea> getPendientes(){
        List<Tarea> list;
        try{
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            list = session.createQuery("from Tarea as ta where ta.estadoTarea = True").list();
            tx.commit();
        }catch(HibernateException e){
            list = null;
            tx.rollback();
            throw e;
        }
        return list;
    }
    
    public List<Tarea> getProyectos(){
        List<Tarea> list;
        try{
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            list = session.createQuery("from Tarea as ta where ta.estadoTarea = True").list();
            tx.commit();
        }catch(HibernateException e){
            list = null;
            tx.rollback();
            throw e;
        }
        return list;
    }
}
