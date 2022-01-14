package com.daw2.fercast.model.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "ofertas")
public class Oferta implements Serializable {
    private Integer id;
    private Double precio;
    private Double precioOferta;
    private Double dtoOferta;
    private Date inicioOferta;
    private Date finalOferta;
    private Articulo articulo;

    @PrePersist
    public void init() {
        inicioOferta = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrecio() {return precio;}
    public void setPrecio(Double precio) {this.precio = precio;}

    public Double getPrecioOferta() {return precioOferta;}
    public void setPrecioOferta(Double precioOferta) {this.precioOferta = precioOferta;}

    public Double getDtoOferta() {return dtoOferta;}
    public void setDtoOferta(Double dtoOferta) {this.dtoOferta = dtoOferta;}

    @Column(name = "inicio_oferta", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getInicioOferta() {
        return inicioOferta;
    }
    public void setInicioOferta(Date inicioOferta) {
        this.inicioOferta = inicioOferta;
    }

    @Column(name = "final_oferta", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFinalOferta() {
        return finalOferta;
    }
    public void setFinalOferta(Date finalOferta) {
        this.finalOferta = finalOferta;
    }

    @ManyToOne
    @JoinColumn(name = "id_articulo", nullable = false)
    public Articulo getArticulo() {
        return articulo;
    }
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

}



