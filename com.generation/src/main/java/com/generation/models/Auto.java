package com.generation.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="autos")
public class Auto {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;
    private String modelo;
    private String marca;
    private Double velocidad;

    @Column(updatable = false) //nos indica que esta columna no se puede actualizar por el sistema.
    private Date createdAt;

    private Date updatedAt;

    //constructores
    public Auto() {
    }

    public Auto(Long id, String color, String modelo, String marca, Double velocidad) {
        this.id = id;
        this.color = color;
        this.modelo = modelo;
        this.marca = marca;
        this.velocidad = velocidad;
    }

    //set y get
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    //funciones
}
