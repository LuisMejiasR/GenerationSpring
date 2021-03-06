package com.generation.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="usuarios")

public class Usuario {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3,max = 20)//limita la cantidad de caracteres
    private String nombre;
    @Size(min = 3,max = 20)
    private String apellido;
    private Integer edad;
    @NotNull
    @Size(min = 6,max = 8)
    private String password;

    @Column(updatable = false) //nos indica que esta columna no se puede actualizar por el sistema.
    private Date createdAt;

    private Date updatedAt;

    //RELACIONAMOS OneToOne (tenemos que hacer la relación entre las dos siempre)
    //con "usuario" relacionamos con el objeto de abajo.
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Licencia licencia;

    //ManyToMany
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_usuarios",//nombre de la tabla relacional
            joinColumns = @JoinColumn(name="usuario_id"),//desde la entidad actual
            inverseJoinColumns = @JoinColumn(name = "rol_id")//la otra entidad o tabla
            )
    private List<Rol> roles;

    //constructores
    public Usuario() {
    }

    public Usuario(String nombre, String apellido, Integer edad, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.password = password;
    }
    //getter y setter


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    //funciones
}
