package com.agenda.model;
// Generated 23/03/2015 08:38:43 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tarea generated by hbm2java
 */
@Entity
@Table(name="tarea"
    ,catalog="agenda"
)
public class Tarea  implements java.io.Serializable {


     private Integer tareaId;
     private String nombre;
     private String descripcion;
     private Date fecha;
     private int ejecucion;
     private boolean estadoTarea;
     private int personaId;
     private int proyectoId;

    public Tarea() {
    }

    public Tarea(String nombre, String descripcion, Date fecha, int ejecucion, boolean estadoTarea, int personaId, int proyectoId) {
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.fecha = fecha;
       this.ejecucion = ejecucion;
       this.estadoTarea = estadoTarea;
       this.personaId = personaId;
       this.proyectoId = proyectoId;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="tarea_id", unique=true, nullable=false)
    public Integer getTareaId() {
        return this.tareaId;
    }
    
    public void setTareaId(Integer tareaId) {
        this.tareaId = tareaId;
    }

    
    @Column(name="nombre", nullable=false, length=60)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="descripcion", nullable=false, length=65535)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha", nullable=false, length=10)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="ejecucion", nullable=false)
    public int getEjecucion() {
        return this.ejecucion;
    }
    
    public void setEjecucion(int ejecucion) {
        this.ejecucion = ejecucion;
    }

    
    @Column(name="estado_tarea", nullable=false)
    public boolean isEstadoTarea() {
        return this.estadoTarea;
    }
    
    public void setEstadoTarea(boolean estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    
    @Column(name="persona_id", nullable=false)
    public int getPersonaId() {
        return this.personaId;
    }
    
    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    
    @Column(name="proyecto_id", nullable=false)
    public int getProyectoId() {
        return this.proyectoId;
    }
    
    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }




}


