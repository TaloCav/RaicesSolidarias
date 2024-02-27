package com.equipo3.raicessolidarias.controller;

import com.equipo3.raicessolidarias.dto.UsuarioDTO;
import com.equipo3.raicessolidarias.model.Usuario;
import com.equipo3.raicessolidarias.service.UsuarioServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioRestController {
    private final UsuarioServiceImpl usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO usuarioRegistrado = usuarioService.registrarUsuario(usuario);
        return new ResponseEntity<>(usuarioRegistrado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        Usuario usuarioBuscado = usuarioService.buscarUsuarioPorId(id);
        return new ResponseEntity<>(usuarioBuscado, HttpStatus.OK);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorEmail(@PathVariable String email) {
        UsuarioDTO usuarioEncontrado = usuarioService.buscarUsuarioPorEmail(email);

        if (usuarioEncontrado != null) {
            return new ResponseEntity<>(usuarioEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> listaDeUsuarios = usuarioService.listarUsuarios();
        return new ResponseEntity<>(listaDeUsuarios, HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO, @RequestParam Long id) {
        UsuarioDTO usuarioActualizado = usuarioService.actualizarUsuario(usuarioDTO, id);
        if (usuarioActualizado != null) {
            return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Usuario no encontrado
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        return new ResponseEntity<>(usuarioService.eliminarUsuario(id), HttpStatus.OK);
    }
}
