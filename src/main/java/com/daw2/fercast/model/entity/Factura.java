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
    private String numero;
    private Date fecha;
    //    private Cliente cliente;
    private Date createAt;
    private List<DetalleFactura> detalleFacturas;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    @NotBlank
    @Column(unique = true, nullable = false, length = 12)
    public String getNumero() {return numero;}
    public void setNumero(String numero) {this.numero = numero;}

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFecha() {return fecha;}
    public void setFecha(Date fecha) {this.fecha = fecha;}

   /* @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    public Cliente getCliente() {return cliente;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}*/

    @PrePersist
    public void init() {
        createAt = new Date();
    }

    @Column(name = "create_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateAt() {return createAt;}
    public void setCreateAt(Date createAt) {this.createAt = createAt;}


    @OneToMany(mappedBy = "factura")
    public List<DetalleFactura> getDetalleFacturas() {
        return detalleFacturas;
    }
    public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }
}
