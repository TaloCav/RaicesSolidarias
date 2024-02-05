package com.equipo3.raicessolidarias.repository;

import com.equipo3.raicessolidarias.model.KitDeSiembra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitDeSiembraRepository extends JpaRepository<KitDeSiembra, Long> {
    public Boolean existsByNombre(String nombre);
}
