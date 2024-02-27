package com.equipo3.raicessolidarias.repository;

import com.equipo3.raicessolidarias.model.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {



    boolean existsByNombre(String nombre);

    List<Actividad> findAllByFecha(LocalDate fecha);
}
