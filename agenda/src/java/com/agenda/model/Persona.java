package com.agenda.model;
// Generated 23/03/2015 08:38:43 PM by Hibernate Tools 4.3.1

import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Persona generated by hbm2java
 */
@Entity
@Table(name="persona"
    ,catalog="agenda"
)
public class Persona  implements java.io.Serializable {


     private Integer personaId;
     private String nombre;
     private String apellido;
     private String email;
     private Set<Tarea> Tareas;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String email) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.email = email;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
     @OneToMany(mappedBy="persona", cascade = CascadeType.ALL)

    
    @Column(name="Persona_id", unique=true, nullable=false)
    public Integer getPersonaId() {
        return this.personaId;
    }
    
    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    
    @Column(name="nombre", nullable=false, length=45)
     @Id
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="apellido", nullable=false, length=90)
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    @Column(name="email", nullable=false, length=60)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }




}


