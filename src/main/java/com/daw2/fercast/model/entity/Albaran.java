package com.daw2.fercast.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "albaranes",
uniqueConstraints = {@UniqueConstraint(columnNames = {"numero", "id_proveedor"})})
public class Albaran implements Serializable {

    private Integer id;
    private String numero;
    private Date fecha;
    private Proveedor proveedor;
    private List<DetalleAlbaran>detalleAlbaranes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    @NotBlank
    @Column(length=15, nullable=false, unique = true)
    public String getNumero() {return numero;}
    public void setNumero(String numero) {this.numero = numero;}


    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFecha() {return fecha;}
    public void setFecha(Date fecha) {this.fecha = fecha;}

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    public Proveedor getProveedor() {return proveedor;}
    public void setProveedor(Proveedor proveedor) {this.proveedor = proveedor;}

    @OneToMany(mappedBy = "albaran")
    public List<DetalleAlbaran> getDetalleAlbaranes() {return detalleAlbaranes;}
    public void setDetalleAlbaranes(List<DetalleAlbaran> detalleAlbaranes) {this.detalleAlbaranes = detalleAlbaranes;}
}
