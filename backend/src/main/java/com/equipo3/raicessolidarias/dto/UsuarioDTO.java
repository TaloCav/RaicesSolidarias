package com.equipo3.raicessolidarias.dto;

import com.equipo3.raicessolidarias.model.Rol;
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
    private List<Rol> roles;

    public int calcularEdad() {
        if (this.fechaDeNacimiento != null) {
            LocalDate ahora = LocalDate.now();
            return Period.between(this.fechaDeNacimiento, ahora).getYears();
        } else {
            return 0;
        }
    }


}
