package com.equipo3.raicessolidarias.service;

import com.equipo3.raicessolidarias.dto.ArbolDTO;
import com.equipo3.raicessolidarias.dto.UsuarioDTO;
import com.equipo3.raicessolidarias.model.Arbol;
import com.equipo3.raicessolidarias.model.Usuario;
import com.equipo3.raicessolidarias.repository.ArbolRepository;
import com.equipo3.raicessolidarias.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@Transactional
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ArbolRepository arbolRepository;
    private final ObjectMapper mapper;


    @Override
    public Usuario registrarNuevoUsuario(Usuario usuario) {
        // Guardar el nuevo usuario en la base de datos
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        return usuarioGuardado; // Devolver el usuario guardado en la base de datos
    }
    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        Boolean usuarioExiste = usuarioRepository.existsById(id);
        if (usuarioExiste) {
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
            return usuarioOptional.orElse(null);
        } else {
            return null;
        }
    }

    public Usuario asignarArbolAUsuario(Long userId, Long arbolId) {
        Usuario usuario = usuarioRepository.findById(userId).orElse(null);
        Arbol arbol = arbolRepository.findById(arbolId).orElse(null);

        if (usuario != null && arbol != null) {
            usuario.agregarArbol(arbol);
            usuarioRepository.save(usuario);

            return usuario;
        } else {
            return null;
        }
    }

    public List<Arbol> obtenerArbolesDeUsuario(Long userId) {
        Usuario usuario = usuarioRepository.findById(userId).orElse(null);

        if (usuario != null) {
            List<Arbol> arbolesAsociados = new ArrayList<>();
            for (Arbol arbol : usuario.getArboles()) {
                if (arbol.getUsuarios().contains(usuario)) {
                    arbolesAsociados.add(arbol);
                }
            }
            return arbolesAsociados;
        } else {
            return new ArrayList<>(); // Devuelve una lista vacía si el usuario no se encuentra
        }
    }

    public int contarArbolesDeUsuario(Long userId) {
        Usuario usuario = usuarioRepository.findById(userId).orElse(null);

        if (usuario != null) {
            return usuario.getArboles().size(); // Devuelve el tamaño de la lista de árboles asociados al usuario
        } else {
            return 0; // Devuelve 0 si el usuario no se encuentra o no tiene árboles asociados
        }
    }



    @Override
    public UsuarioDTO buscarUsuarioPorEmail(String email) {
        return null;
    }


    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }



    @Override
    public UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO, Long id) {

        Usuario usuarioExistente = buscarUsuarioPorId(id);
        if (usuarioExistente != null) {
            // Actualizar los campos del usuario existente con los datos del usuarioDTO
            usuarioExistente.setNombre(usuarioDTO.getNombre());
            usuarioExistente.setApellido(usuarioDTO.getApellido());
            usuarioExistente.setEmail(usuarioDTO.getEmail());
            usuarioExistente.setPassword(usuarioDTO.getContrasenia());
            usuarioExistente.setFechaDeNacimiento(usuarioDTO.getFechaDeNacimiento());


            Usuario usuarioActualizado = usuarioRepository.save(usuarioExistente);

            // Conversion a usuarioDTO
            return mapper.convertValue(usuarioActualizado, UsuarioDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public String eliminarUsuario(Long id) {
        Boolean usuarioExiste = usuarioRepository.existsById(id);
        if(usuarioExiste) {
            usuarioRepository.deleteById(id);
            return "El usuario ha sido eliminado.";
        } else {
            return "El usuario no existe en la base de datos.";
        }
    }


    public Boolean existeUsuarioPorEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }


}

