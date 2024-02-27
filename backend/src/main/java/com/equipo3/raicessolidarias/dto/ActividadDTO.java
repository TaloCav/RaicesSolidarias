package com.equipo3.raicessolidarias.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ActividadDTO {

    private String nombre;
    private LocalDate fecha;
    private String descripcion;
    private Integer arbolesSembrados;

}
