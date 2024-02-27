package com.equipo3.raicessolidarias.repository;

import com.equipo3.raicessolidarias.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Boolean existsByEmail(String email);
    public Usuario findUsuarioByEmail(String email);

}