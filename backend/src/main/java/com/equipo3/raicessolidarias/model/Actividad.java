package com.equipo3.raicessolidarias.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = " actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la actividad es obligatorio")
    @Column(name= "nombre", nullable = false )
    private String nombre;

    @NotNull(message = "La fecha de la actividad es obligatoria")
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @NotNull(message = "La descrición de la actividad es obligatoria")
    @Column (name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "arbolesSembrados", nullable = false)
    @Max(value = 1000)
    private Integer arbolesSembrados;

    @JsonIgnore
    @OneToMany(mappedBy = "actividadArbol", cascade = CascadeType.ALL)
    private List<Arbol> arbolesSembradosActividad;

}
