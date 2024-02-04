package com.equipo3.raicessolidarias.controller;

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
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioRegistrado = usuarioService.registrarUsuario(usuario);
        return new ResponseEntity<>(usuarioRegistrado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        Usuario usuarioBuscado = usuarioService.buscarUsuarioPorId(id);
        return new ResponseEntity<>(usuarioBuscado, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> listaDeUsuarios = usuarioService.listarUsuarios();
        return new ResponseEntity<>(listaDeUsuarios, HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioActualizado= usuarioService.actualizarUsuario(usuario);
        return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        return new ResponseEntity<>(usuarioService.eliminarUsuario(id), HttpStatus.OK);
    }
}
