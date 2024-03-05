package com.equipo3.raicessolidarias.service;

import com.equipo3.raicessolidarias.dto.UsuarioDTO;
import com.equipo3.raicessolidarias.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario registrarNuevoUsuario(Usuario usuario);

    Usuario buscarUsuarioPorId(Long id);

    UsuarioDTO buscarUsuarioPorEmail(String email);

    List<Usuario> listarUsuarios();

    UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO, Long id);


    String eliminarUsuario(Long id);

    Boolean existeUsuarioPorEmail(String email);




}
