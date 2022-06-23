package com.generation.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="licencias")
public class Licencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private Date fechaVencimiento;
    private String clase;
    private Boolean vencida;

    //opcionales, sirven para gestion de base de datos
    @Column(updatable = false) //nos indica que esta columna no se puede actualizar por el sistema.
    private Date createdAt;
    private Date updatedAt;
    /*private Date deletedAt; -> fecha de eliminación logica (no lo borramos, solo le damos de baja)*/

    public Licencia() {
    }

    public Licencia(Long id, Integer numero, Date fechaVencimiento, String clase, Boolean vencida) {
        this.id = id;
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.clase = clase;
        this.vencida = vencida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Boolean getVencida() {
        return vencida;
    }

    public void setVencida(Boolean vencida) {
        this.vencida = vencida;
    }

    //Insertara en el atributo la fecha antes de insertar en la BD.
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
