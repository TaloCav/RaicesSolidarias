package com.equipo3.raicessolidarias.service;

import com.equipo3.raicessolidarias.dto.UsuarioDTO;
import com.equipo3.raicessolidarias.model.Usuario;
import com.equipo3.raicessolidarias.repository.UsuarioRepository;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO);

    Usuario buscarUsuarioPorId(Long id);

    UsuarioDTO buscarUsuarioPorEmail(String email);

    List<Usuario> listarUsuarios();

    UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO, Long id);

    String eliminarUsuario(Long id);

}
