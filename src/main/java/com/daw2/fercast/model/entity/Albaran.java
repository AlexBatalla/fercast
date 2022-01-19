package com.daw2.fercast.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "albaranes")
public class Albaran implements Serializable {

    private Integer id;
    private String ref;
    private Date fecha;
    private List<DetalleAlbaran>detalleAlbaranes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    @NotBlank
    @Column(length=15, nullable=false, unique = true)
    public String getRef() {return ref;}
    public void setRef(String ref) {this.ref = ref;}

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFecha() {return fecha;}
    public void setFecha(Date fecha) {this.fecha = fecha;}

    @OneToMany(mappedBy = "albaran")
    public List<DetalleAlbaran> getDetalleAlbaranes() {return detalleAlbaranes;}
    public void setDetalleAlbaranes(List<DetalleAlbaran> detalleAlbaranes) {this.detalleAlbaranes = detalleAlbaranes;}
}
