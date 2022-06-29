package com.generation.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    private Float Valor;

    //ManyToMany con autosComprasVentas
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "autos_compras_ventas",//nombre de la tabla relacional
            joinColumns = @JoinColumn(name="auto_id"),//desde la entidad actual
            inverseJoinColumns = @JoinColumn(name = "compra_venta_id")//la otra entidad o tabla
    )
    private List<CompraVenta> comprasVentas;
    @Column(updatable = false) //nos indica que esta columna no se puede actualizar por el sistema.
    private Date createdAt;

    private Date updatedAt;

    //constructores

    public Auto() {
    }

    //no se agrega el id, la creacion de fechas, ni la lista.
    public Auto(String color, String modelo, String marca, Double velocidad, Float valor) {
        this.color = color;
        this.modelo = modelo;
        this.marca = marca;
        this.velocidad = velocidad;
        Valor = valor;
    }

    public Auto(String color, String modelo, String marca, Double velocidad, Float valor, List<CompraVenta> listaComprasVentas) {
        this.color = color;
        this.modelo = modelo;
        this.marca = marca;
        this.velocidad = velocidad;
        Valor = valor;
        this.comprasVentas = comprasVentas;
    }

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

    public Float getValor() {
        return Valor;
    }

    public void setValor(Float valor) {
        Valor = valor;
    }

    public List<CompraVenta> getComprasVentas() {
        return comprasVentas;
    }

    public void setComprasVentas(List<CompraVenta> comprasVentas) {
        this.comprasVentas = comprasVentas;
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
