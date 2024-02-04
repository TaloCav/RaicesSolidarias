package com.equipo3.raicessolidarias.repository;

import com.equipo3.raicessolidarias.model.Arbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbolRepository extends JpaRepository<Arbol, Long> {
    public Boolean existsByNombreCientifico(String nombreCientifico);
}
