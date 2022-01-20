package com.daw2.fercast.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
    private Integer id;
    private String username;  // En este proyecto el username sería igual al email
    private String password;
    private String email;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private boolean activo;
    private int numIntentos;
    private boolean bloqueado;
    private Date ultimoAcceso;
    private Date createAt;
    private Date modifiedAt;
    private List<Rol> roles;
    private List<Register> registers;
    private Cliente cliente;
    private List<PasswordRenew> passwordRenews;



    @PrePersist
    public void init() {createAt = new Date();}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    @Email
    @Column(length=75, nullable=false, unique=true)
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    @NotBlank
    @Column(length=60, nullable=false)
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    @Email
    @Column(length=75, nullable=false, unique=true)
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    @NotBlank
    @Column(length=20, nullable=false)
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    @NotBlank
    @Column(length=20, nullable=false)
    public String getApellido1() {return apellido1;}
    public void setApellido1(String apellido1) {this.apellido1 = apellido1;}

    @Column(length=20)
    public String getApellido2() {return apellido2;}
    public void setApellido2(String apellido2) {this.apellido2 = apellido2;}

    @Column(nullable=false)
    public boolean isActivo() {return activo;}
    public void setActivo(boolean activo) {this.activo = activo;}

    @Column(nullable=false)
    public int getNumIntentos() { return numIntentos; }
    public void setNumIntentos(int numIntentos) { this.numIntentos = numIntentos; }

    @Column(nullable=false)
    public boolean isBloqueado() { return bloqueado; }
    public void setBloqueado(boolean bloqueado) { this.bloqueado = bloqueado; }

    @Column(name = "ultimo_acceso")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getUltimoAcceso() { return ultimoAcceso; }
    public void setUltimoAcceso(Date ultimoAcceso) { this.ultimoAcceso = ultimoAcceso; }

    @Column(name = "create_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateAt() { return createAt; }
    public void setCreateAt(Date createAt) { this.createAt = createAt; }

    @Column(name = "modified_at")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getModifiedAt() { return modifiedAt; }
    public void setModifiedAt(Date modifiedAt) { this.modifiedAt = modifiedAt; }

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="usuarios_roles", joinColumns= @JoinColumn(name="id_usuario", nullable = false),
            inverseJoinColumns=@JoinColumn(name="id_rol", nullable = false),
            uniqueConstraints= {@UniqueConstraint(columnNames= {"id_usuario", "id_rol"})})
    public List<Rol> getRoles() {return roles;}
    public void setRoles(List<Rol> roles) {this.roles = roles;}

    @OneToMany(mappedBy = "usuario")
    public List<Register> getRegisters() {return registers;}
    public void setRegisters(List<Register> registers) {this.registers = registers;}

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    public Cliente getCliente() {return cliente;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}

    @OneToMany(mappedBy = "usuario")
    public List<PasswordRenew> getPasswordRenews() {return passwordRenews;}
    public void setPasswordRenews(List<PasswordRenew> passwordRenews) {this.passwordRenews = passwordRenews;}
}