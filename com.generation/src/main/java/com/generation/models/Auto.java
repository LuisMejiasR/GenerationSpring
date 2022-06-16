package com.generation.models;

import javax.persistence.*;

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
    //funciones
}
