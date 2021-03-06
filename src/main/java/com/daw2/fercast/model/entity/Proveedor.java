package com.daw2.fercast.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "proveedores")
public class Proveedor implements Serializable {
    private Integer id;
    private String nif;
    private String razonSocial;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String mail;
    private Date createAt;
    private Date modifiedAt;
    private List<Articulo> articulos;
    private List<Albaran> albaranes;

    @PrePersist
    public void init() {
        createAt = new Date();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    @NotBlank
    @Column(unique = true,nullable = false,length = 12)
    public String getNif() {return nif;}
    public void setNif(String nif) {this.nif = nif;}

    @NotBlank
    @Column( name = "razon_social",unique = true,nullable = false,length = 150)
    public String getRazonSocial() {return razonSocial;}
    public void setRazonSocial(String razonSocial) {this.razonSocial = razonSocial;}

    @NotBlank
    @Column(nullable = false, length = 20)
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    @NotBlank
    @Column(nullable = false, length = 20)
    public String getApellido1() {return apellido1;}
    public void setApellido1(String apellido1) {this.apellido1 = apellido1;}

    @Column(length = 12)
    public String getApellido2() {return apellido2;}
    public void setApellido2(String apellido2) {this.apellido2 = apellido2;}

    @Column(length = 15)
    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}

    @Email
    @Column(length = 75)
    public String getMail() {return mail;}
    public void setMail(String mail) {this.mail = mail;}

    @Column(name = "create_at", nullable = false)
//    No es necesario @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateAt() {return createAt;}
    public void setCreateAt(Date createAt) {this.createAt = createAt;}

    @Column(name = "modified_at")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getModifiedAt() {return modifiedAt;}
    public void setModifiedAt(Date modified_at) {this.modifiedAt = modifiedAt;}

    @OneToMany(mappedBy = "proveedor")//FK en proveedores
    public List<Articulo> getArticulos() {return articulos;}
    public void setArticulos(List<Articulo> articulos) {this.articulos = articulos;}

    @OneToMany(mappedBy = "proveedor")
    public List<Albaran> getAlbaranes() { return albaranes;}
    public void setAlbaranes(List<Albaran> albaranes) {this.albaranes = albaranes;}
}
