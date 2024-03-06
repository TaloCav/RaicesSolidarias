package com.equipo3.raicessolidarias.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Max;
import java.util.Set;

@Entity
@Data
@Table(name = "Arboles")
public class Arbol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_comun", nullable = false)
    @Max(value = 30)
    private String nombreComun;

    @Column(name = "nombre_cientifico", unique = true, nullable = false)
    @Max(value = 30)
    private String nombreCientifico;

    @Column(name = "tipo", unique = true, nullable = false)
    @Max(value = 30)
    private String tipo;

    private Double precio;





    @ManyToMany(mappedBy = "arboles")
    private Set<Usuario> usuarios;



}
