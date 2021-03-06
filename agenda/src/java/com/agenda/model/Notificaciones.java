package com.agenda.model;
// Generated 23/03/2015 08:38:43 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Notificaciones generated by hbm2java
 */
@Entity
@Table(name="notificaciones"
    ,catalog="agenda"
)
public class Notificaciones  implements java.io.Serializable {


     private Integer notificacionId;
     private int tareaId;

    public Notificaciones() {
    }

    public Notificaciones(int tareaId) {
       this.tareaId = tareaId;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="notificacion_id", unique=true, nullable=false)
    public Integer getNotificacionId() {
        return this.notificacionId;
    }
    
    public void setNotificacionId(Integer notificacionId) {
        this.notificacionId = notificacionId;
    }

    
    @Column(name="tarea_id", nullable=false)
    public int getTareaId() {
        return this.tareaId;
    }
    
    public void setTareaId(int tareaId) {
        this.tareaId = tareaId;
    }




}


