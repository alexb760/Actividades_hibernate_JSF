/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.dao;

import com.agenda.model.Proyecto;
import com.agenda.model.Tarea;
import com.agenda.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Usuario
 */
public class ProyectoDaoImpl extends GenericDaoImpl<Proyecto, Integer> implements ProyectoDao{
    
    public List<?> getProyectos(){
        List<?> list;
        try{
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            list = session.createQuery("from Proyecto as pr, Tarea as ta where pr.proyectoId = ta.proyecto and ta.estadoTarea = 0").list();

            tx.commit();
        }catch(HibernateException e){
            list = null;
            tx.rollback();
            throw e;
        }
        return list;
    }
}
