package com.daw2.fercast.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "novedades")
public class Novedad implements Serializable {
    private Integer id;
    private Articulo articulo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    @ManyToOne
    @JoinColumn(name = "id_articulo", nullable = false)
    public Articulo getArticulo() {return articulo;}
    public void setArticulo(Articulo articulo) {this.articulo = articulo;}
}
