package com.equipo3.raicessolidarias.controller;

import com.equipo3.raicessolidarias.dto.ArbolDTO;
import com.equipo3.raicessolidarias.model.Arbol;
import com.equipo3.raicessolidarias.service.ArbolServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/arbol")
public class ArbolRestController {
    private final ArbolServiceImpl arbolService;
    @PostMapping("/registrar")
    public ResponseEntity<ArbolDTO> registrarArbol(@RequestBody ArbolDTO arbol) {
        ArbolDTO arbolRegistrado = arbolService.registrarArbol(arbol);
        return new ResponseEntity<>(arbolRegistrado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arbol> buscarArbolPorId(@PathVariable Long id) {
        Arbol arbolBuscado = arbolService.buscarArbolPorId(id);
        return new ResponseEntity<>(arbolBuscado, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Arbol>> listarArboles() {
        List<Arbol> listaDeArboles = arbolService.listarArboles();
        return new ResponseEntity<>(listaDeArboles, HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ArbolDTO> actualizarArbol(@RequestBody ArbolDTO arbolDTO, @RequestParam Long id) {
        // Llama al servicio para actualizar el árbol
        ArbolDTO arbolActualizadoDTO = arbolService.actualizarArbol(arbolDTO, id);

        if (arbolActualizadoDTO != null) { // Si el árbol se actualizó correctamente
            return new ResponseEntity<>(arbolActualizadoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Devuelve NOT FOUND si el árbol no se encuentra
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarArbol(@PathVariable Long id) {
        return new ResponseEntity<>(arbolService.eliminarArbol(id), HttpStatus.OK);
    }
}
