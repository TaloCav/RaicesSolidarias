package com.equipo3.raicessolidarias.repository;
import com.equipo3.raicessolidarias.model.ERol;
import com.equipo3.raicessolidarias.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(ERol nombre);
}