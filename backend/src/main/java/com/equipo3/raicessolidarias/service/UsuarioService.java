package com.equipo3.raicessolidarias.service;

import com.equipo3.raicessolidarias.model.Usuario;
import com.equipo3.raicessolidarias.repository.UsuarioRepository;

import java.util.List;

public interface UsuarioService {
    Usuario registrarUsuario(Usuario usuario);
    Usuario buscarUsuarioPorId(Long id);
    List<Usuario> listarUsuarios();
    Usuario actualizarUsuario(Usuario usuario);
    String eliminarUsuario(Long id);
}
