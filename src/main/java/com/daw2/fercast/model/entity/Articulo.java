package com.daw2.fercast.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "articulos")
public class Articulo implements Serializable {
    private Integer id;
    private String ref;
    private String descripcion;
    private Double precio;
    private Double iva;
    private Double dto;
    private Double stock;
    private String imagen;
    private Proveedor proveedor;
    private Subcategoria subcategoria;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {return id;}
    public void setId(Integer id) { this.id = id;}

    @NotBlank
    @Column(unique = true, nullable = false, length=15)
    public String getRef() { return ref;}
    public void setRef(String ref) { this.ref = ref;}

    @NotBlank
    @Column(nullable = false, length=75)
    public String getDescripcion() { return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public Double getPrecio() { return precio;}
    public void setPrecio(Double precio) {this.precio = precio;}

    public Double getIva() {return iva;}
    public void setIva(Double iva) {this.iva = iva;}

    public Double getDto() {return dto;}
    public void setDto(Double dto) {this.dto = dto;}

    public Double getStock() {return stock;}
    public void setStock(Double stock) {this.stock = stock;}

    @Column(length = 75)
    public String getImagen() {return imagen;}
    public void setImagen(String imagen) {this.imagen = imagen;}

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    public Proveedor getProveedor() {return proveedor;}
    public void setProveedor(Proveedor proveedor) {this.proveedor = proveedor;}

    @ManyToOne
    @JoinColumn(name = "id_subcategoria", nullable = false)
    public Subcategoria getSubcategoria() { return subcategoria;}
    public void setSubcategoria(Subcategoria subcategoria) { this.subcategoria = subcategoria;}
}

