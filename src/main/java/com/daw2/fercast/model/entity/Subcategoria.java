package com.daw2.fercast.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "subcategorias")
public class Subcategoria implements Serializable {
    private Integer id;
    private String ref;
    private String descripcion;
    private Double iva;
    private List<Articulo> articulos;
    private Categoria categoria;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    @NotBlank
    @Column(unique = true,nullable = false,length = 12)
    public String getRef() {return ref;}
    public void setRef(String ref) {this.ref = ref;}

    @NotBlank
    @Column(nullable = false,length = 50)
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;    }

    public Double getIva() {return iva;}
    public void setIva(Double iva) {this.iva = iva;}

    @OneToMany(mappedBy = "subcategoria")//FK en subcategoria
    public List<Articulo> getArticulos() {return articulos;}
    public void setArticulos(List<Articulo> articulos) {this.articulos = articulos;}

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    public Categoria getCategoria() {return categoria;}
    public void setCategoria(Categoria categoria) {this.categoria = categoria;}

}
