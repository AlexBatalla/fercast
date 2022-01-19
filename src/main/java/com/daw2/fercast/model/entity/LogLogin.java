package com.daw2.fercast.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "log_logins")
public class LogLogin implements Serializable {

    private Integer id;
    private String username;
    private String ip;
    private String  codOpercion;
    private String descripcion;
    private Date createAt;

    @PrePersist
    public void init() {
        createAt = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}


    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}


    public String getIp() { return  ip;}
    public void setIp(String ip) {this.ip = ip;}

    public String getCodOpercion() { return codOpercion;}
    public void setCodOpercion(String codOpercion) {this.codOpercion = codOpercion; }

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public Date getCreateAt() { return createAt;}
    public void setCreateAt(Date createAt) {this.createAt = createAt;}
}
