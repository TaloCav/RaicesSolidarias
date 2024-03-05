package com.equipo3.raicessolidarias.service;

import com.equipo3.raicessolidarias.dto.UsuarioDTO;
import com.equipo3.raicessolidarias.model.Usuario;
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


    @Override
    public UsuarioDTO buscarUsuarioPorEmail(String email) {
        Boolean usuarioExiste = usuarioRepository.existsByEmail(email);
        if(usuarioExiste) {
            return mapper.convertValue(usuarioRepository.findUsuarioByEmail(email),UsuarioDTO.class);
        } else {
            return null;
        }
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
    public Boolean existeUsuarioPorUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }

    public Boolean existeUsuarioPorEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
}