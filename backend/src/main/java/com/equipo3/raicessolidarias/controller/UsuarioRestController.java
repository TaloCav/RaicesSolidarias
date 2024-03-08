package com.equipo3.raicessolidarias.controller;

import com.equipo3.raicessolidarias.dto.ArbolDTO;
import com.equipo3.raicessolidarias.dto.UsuarioDTO;
import com.equipo3.raicessolidarias.model.Arbol;
import com.equipo3.raicessolidarias.model.Rol;
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
    @PostMapping("/asignar-arbol")
    public ResponseEntity<String> asignarArbolAUsuario(@RequestBody Map<String, Object> request) {
        String email = (String) request.get("email");
        Long arbolId = Long.valueOf(request.get("arbolId").toString());

        Usuario usuario = usuarioService.asignarArbolAUsuario(email, arbolId);
        if (usuario != null) {
            return ResponseEntity.ok("El árbol fue asignado correctamente al usuario con email: " + email);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{email}/arboles")
    public List<ArbolDTO> obtenerArbolesDeUsuario(@PathVariable String email) {
        Usuario usuario = usuarioRepository.findUsuarioByEmail(email);

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

    @GetMapping("/{email}/numero-arboles")
    public int contarArbolesDeUsuario(@PathVariable String email) {
        return usuarioService.contarArbolesDeUsuario(email);
    }

    @GetMapping("/{email}/atributos")
    public List<Object[]> getAttributesByEmail(@PathVariable String email) {
        return usuarioService.getAttributesByEmail(email);
    }
    @GetMapping("/{email}/roles")
    public List<Rol> getRolesByEmail(@PathVariable String email) {
        return usuarioService.getRolesByEmail(email);
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