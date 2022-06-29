package com.generation.models;

import javax.persistence.*;
import java.util.Date;

//tabla relacional
@Entity
@Table(name = "autos_compras_ventas")
public class AutoCompraVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;
    private Float subtotal;
    private Date fecha;
    /**ManyToMany = 2 ManyToOne*/
    //ManyToOne con Auto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auto_id")
    private Auto auto;

    //ManyToOne con CompraVenta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compra_venta_id")
    private CompraVenta compraVenta;

    public AutoCompraVenta() {
    }

    public AutoCompraVenta(Integer cantidad, Float subtotal, Date fecha, Auto auto, CompraVenta compraVenta) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.fecha = fecha;
        this.auto = auto;
        this.compraVenta = compraVenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public CompraVenta getCompraVenta() {
        return compraVenta;
    }

    public void setCompraVenta(CompraVenta compraVenta) {
        this.compraVenta = compraVenta;
    }
}
