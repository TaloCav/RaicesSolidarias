package com.equipo3.raicessolidarias.service;

import com.equipo3.raicessolidarias.model.Usuario;
import com.equipo3.raicessolidarias.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        Boolean usuarioExiste = usuarioRepository.existsByEmail(usuario.getEmail());
        int edad = usuario.calcularEdad();

        if(usuarioExiste || edad < 18) {
            return null;
        } else {
            return usuarioRepository.save(usuario);
        }
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        Boolean usuarioExiste = usuarioRepository.existsById(id);
        if(usuarioExiste) {
            return usuarioRepository.findById(id).get(); // Preguntar a Ale why
        } else {
            return null;
        }
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        Boolean usuarioExiste = usuarioRepository.existsById(usuario.getId());
        if (usuarioExiste && usuario != null) {
            return usuarioRepository.save(usuario);
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
}
