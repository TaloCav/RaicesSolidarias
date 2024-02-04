package com.equipo3.raicessolidarias.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Data
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Min(value = 2, message = "El nombre no puede ser inferior a 2 caracteres.")
    @Max(value = 20, message = "El nombre no puede ser superior a 20 caracteres.")
    private String nombre;

    @Column(nullable = false)
    @Min(value = 2, message = "El apellido no puede ser inferior a 2 caracteres.")
    @Max(value = 20, message = "El apellido no puede ser superior a 20 caracteres.")
    private String apellido;

    private Genero genero;

    @Column(unique = true, nullable = false)
    @Min(value = 10, message = "El email no puede ser inferior a 10 caracteres.")
    private String email;

    @Column(nullable = false)
    @Min(value = 6, message = "La contraseña no puede ser inferior a 6 caracteres.")
    @Max(value = 12, message = "La contraseña no puede ser superior a 12 caracteres.")
    private String contrasenia;
    /*
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private List<Rol> roles;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "direccion_id", nullable = false)
    private Direccion direccion;
    */
}