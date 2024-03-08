package com.equipo3.raicessolidarias.repository;

import com.equipo3.raicessolidarias.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Boolean existsByEmail(String email);
    public Usuario findUsuarioByEmail(String email);

    Optional<Usuario> findByEmail(String email);

    @Query("SELECT u.nombre, u.apellido, u.fechaDeNacimiento FROM Usuario u WHERE u.email = :email")
    List<Object[]> findAttributesByEmail(@Param("email") String email);




}