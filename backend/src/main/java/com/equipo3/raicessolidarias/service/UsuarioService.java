package com.equipo3.raicessolidarias.service;

import com.equipo3.raicessolidarias.dto.ArbolDTO;
import com.equipo3.raicessolidarias.dto.UsuarioDTO;
import com.equipo3.raicessolidarias.model.Arbol;
import com.equipo3.raicessolidarias.model.Rol;
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

    Usuario asignarArbolAUsuario(String email, Long arbolId);

    List<Arbol> obtenerArbolesAsociados(String email);

    int contarArbolesDeUsuario(String email);

    List<Object[]> getAttributesByEmail(String email);

    List<Rol> getRolesByEmail(String email);





}
