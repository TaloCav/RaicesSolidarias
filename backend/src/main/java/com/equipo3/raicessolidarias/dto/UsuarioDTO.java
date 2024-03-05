package com.equipo3.raicessolidarias.dto;

import com.equipo3.raicessolidarias.model.ERol;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Data
public class UsuarioDTO {

    private LocalDate fechaDeNacimiento;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasenia;
    private List<ERol> roles;




}
