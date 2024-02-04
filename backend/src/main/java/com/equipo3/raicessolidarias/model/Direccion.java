package com.equipo3.raicessolidarias.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
@Table(name = "Direcciones")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Max(value = 50)
    private String calle;

    @Column(name = "numero_calle", nullable = false)
    @Min(value = 2)
    @Max(value = 6)
    private String numCalle;

    @Column(nullable = false)
    @Max(value = 30)
    private String comuna;

    @Column(nullable = false)
    @Max(value = 30)
    private String region;

    // private String cardinalidad;
}
