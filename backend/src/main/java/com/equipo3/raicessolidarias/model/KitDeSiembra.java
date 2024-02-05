package com.equipo3.raicessolidarias.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "KitsDeSiembra")
public class KitDeSiembra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_kit", unique = true, nullable = false)
    private String nombreKit;

    @Column(nullable = false)
    private Double precio;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arbol_id", nullable = false)
    private Arbol arbol;
}