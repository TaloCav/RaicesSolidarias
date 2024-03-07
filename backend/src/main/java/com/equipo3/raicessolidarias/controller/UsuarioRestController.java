package com.equipo3.raicessolidarias.controller;

import com.equipo3.raicessolidarias.dto.ArbolDTO;
import com.equipo3.raicessolidarias.dto.UsuarioDTO;
import com.equipo3.raicessolidarias.model.Arbol;
import com.equipo3.raicessolidarias.model.Usuario;
import com.equipo3.raicessolidarias.repository.UsuarioRepository;
import com.equipo3.raicessolidarias.service.UsuarioServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioRestController {
    private final UsuarioServiceImpl usuarioService;
    private final UsuarioRepository usuarioRepository;



    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrarNuevoUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioGuardado = usuarioService.registrarNuevoUsuario(usuario);
        if (usuarioGuardado != null) {
            return ResponseEntity.ok(usuarioGuardado);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/{userId}/arboles/{arbolId}")
    public ResponseEntity<String> asignarArbolAUsuario(@PathVariable Long userId, @PathVariable Long arbolId) {
        Usuario usuario = usuarioService.asignarArbolAUsuario(userId, arbolId);
        if (usuario != null) {
            return new ResponseEntity<>("El árbol fue asignado correctamente al usuario.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontró el usuario o el árbol.", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{userId}/arboles")
    public List<ArbolDTO> obtenerArbolesDeUsuario(@PathVariable Long userId) {
        Usuario usuario = usuarioRepository.findById(userId).orElse(null);

        if (usuario != null) {
            List<ArbolDTO> arbolesAsociados = new ArrayList<>();
            for (Arbol arbol : usuario.getArboles()) {
                ArbolDTO arbolDTO = new ArbolDTO();
                arbolDTO.setId(arbol.getId());
                arbolDTO.setNombreComun(arbol.getNombreComun());
                arbolDTO.setNombreCientifico(arbol.getNombreCientifico());
                arbolDTO.setTipo(arbol.getTipo());
                arbolDTO.setPrecio(arbol.getPrecio());
                arbolesAsociados.add(arbolDTO);
            }
            return arbolesAsociados;
        } else {
            return new ArrayList<>(); // Devuelve una lista vacía si el usuario no se encuentra
        }
    }

    @GetMapping("/{userId}/numero-arboles")
    public ResponseEntity<Integer> obtenerNumeroDeArbolesDeUsuario(@PathVariable Long userId) {
        int numeroDeArboles = usuarioService.contarArbolesDeUsuario(userId);
        return ResponseEntity.ok(numeroDeArboles);
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