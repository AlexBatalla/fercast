package com.daw2.fercast.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
    private Integer id;
    private Integer ref;
    private Integer descripcion;
    private Double iva;
    private List<Subcategoria> subcategoria;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    @NotBlank
    @Column(unique = true,nullable = false,length = 10)
    public Integer getRef() {return ref;}
    public void setRef(Integer ref) {this.ref = ref;}

    @NotBlank
    @Column(nullable = false,length = 50)
    public Integer getDescripcion() {return descripcion;}
    public void setDescripcion(Integer descripcion) {this.descripcion = descripcion;}

    public Double getIva() {return iva;}
    public void setIva(Double iva) {this.iva = iva;}

    @OneToMany(mappedBy = "categoria")//FK en categoria
    public List<Subcategoria> getSubcategoria() {return subcategoria;}
    public void setSubcategoria(List<Subcategoria> subcategoria) {this.subcategoria = subcategoria;}
}
