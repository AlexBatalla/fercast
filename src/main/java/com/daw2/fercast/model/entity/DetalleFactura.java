package com.daw2.fercast.model.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "detalle_facturas")
public class DetalleFactura implements Serializable {

    private Integer id;
    private double precio;
    private double iva;
    private double unidades;
    private double dto;
    private Articulo articulo;
    private Factura factura;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Double getPrecio() {return precio;}
    public void setPrecio(Double precio) {this.precio = precio;}

    public Double getIva() {return iva;}
    public void setIva(Double iva) {this.iva = iva;}

    public Double getUnidades() {return unidades;}
    public void setUnidades(Double unidades) {this.unidades = unidades;}

    public Double getDto() {return dto;}
    public void setDto(Double dto) {this.dto = dto;}

    @ManyToOne
    @JoinColumn(name = "id_articulo", nullable = false)
    public Articulo getArticulo() {return articulo;}
    public void setArticulo(Articulo articulo) {this.articulo = articulo;}

    @ManyToOne//Carga perezosa(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factura", nullable = false)
    public Factura getFactura() {
        return factura;
    }
    public void setFactura(Factura factura) {this.factura = factura;}


}
