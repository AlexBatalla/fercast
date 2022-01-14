package com.daw2.fercast.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "facturas")
public class Factura implements Serializable {
    private Integer id;
    private Double numero;
    private Date fecha;
    private Date createAt;
    private List<DetalleFactura> detalleFacturas;

    @PrePersist
    public void init() {fecha = new Date();}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    @NotBlank
    @Column(unique = true, nullable = false, length = 12)
    public Double getNumero() {return numero;}
    public void setNumero(Double numero) {this.numero = numero;}

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "create_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateAt() {
        return createAt;
    }
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @OneToMany(mappedBy = "factura")
    public List<DetalleFactura> getDetalleFacturas() {return detalleFacturas;}
    public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {this.detalleFacturas = detalleFacturas;}

}




