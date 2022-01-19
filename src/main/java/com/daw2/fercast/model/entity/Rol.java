package com.daw2.fercast.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {
    private Integer id;
    private String rol;
    private String descripcion;
    private List<Usuario> usuarios;

    public Rol() {}
    public Rol(String rol) {this.rol = rol;}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {this.id = id;}

    @Column(length = 15, nullable = false, unique = true)
    public String getRol() {return rol;}
    public void setRol(String rol) {this.rol = rol;}

    @Column(length = 25, nullable = false)
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    @ManyToMany(mappedBy = "roles")
    public List<Usuario> getUsuarios() {return usuarios;}
    public void setUsuarios(List<Usuario> usuarios) {this.usuarios = usuarios;}
}