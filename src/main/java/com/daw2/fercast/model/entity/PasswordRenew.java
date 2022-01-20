package com.daw2.fercast.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "password_renews")
public class PasswordRenew implements Serializable {
    private Integer id;
    private String codigoSolicitud;
    private String email;
    private Usuario usuario;
    private Date createAt;


    @PrePersist
    public void init() {
        createAt = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    @NotBlank
    @Column(unique = true, nullable = false, length = 50, name = "codigo_solicitud")
    public String getCodigoSolicitud() {return codigoSolicitud;}
    public void setCodigoSolicitud(String codigoSolicitud) {this.codigoSolicitud = codigoSolicitud;}

    @Email
    @Column(length = 75)
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, unique = true)
    public Usuario getUsuario() {return usuario;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}

    @Column(name = "create_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateAt() {return createAt;}
    public void setCreateAt(Date createAt) {this.createAt = createAt;}
}
