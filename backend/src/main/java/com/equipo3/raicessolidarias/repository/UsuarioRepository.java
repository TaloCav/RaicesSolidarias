package com.equipo3.raicessolidarias.repository;

import com.equipo3.raicessolidarias.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Boolean existsByEmail(String email);
    public Usuario findUsuarioByEmail(String email);

    Optional<Usuario> findByUsername(String username);
    Boolean existsByUsername(String username);




}