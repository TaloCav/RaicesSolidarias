package com.equipo3.raicessolidarias.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_rol", nullable = false)
    private NombreRol nombreRol;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;
}
