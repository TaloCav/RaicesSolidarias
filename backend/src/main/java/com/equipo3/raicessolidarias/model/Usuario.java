package com.equipo3.raicessolidarias.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchConnectionDetails;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Max(value = 20, message = "El nombre no puede ser superior a 20 caracteres.")
    private String nombre;



    @Max(value = 20, message = "El apellido no puede ser superior a 20 caracteres.")
    private String apellido;

    @Size(max = 20)
    @Column(unique = true)
    private String username;

    @Enumerated(EnumType.STRING)
    private Genero genero;


    @Column(name = "fecha_de_nacimiento")
    private LocalDate fechaDeNacimiento;

    @Column(unique = true, nullable = false)
    @Min(value = 10, message = "El email no puede ser inferior a 10 caracteres.")
    private String email;


    @Min(value = 6, message = "La contraseña no puede ser inferior a 6 caracteres.")
    @Max(value = 12, message = "La contraseña no puede ser superior a 12 caracteres.")
    private String password;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuario_actividad",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "actividad_id")
    )
    private Set<Actividad> actividades;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuario_arbol",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "arbol_id")
    )
    private List<Arbol> arboles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    public int calcularEdad() {
        if (this.fechaDeNacimiento != null) {

            LocalDate ahora = LocalDate.now();
            return Period.between(this.fechaDeNacimiento, ahora).getYears();
        } else {
            return 0;
        }
    }


}



