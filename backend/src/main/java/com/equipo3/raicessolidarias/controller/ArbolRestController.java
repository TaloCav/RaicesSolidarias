package com.equipo3.raicessolidarias.controller;

import com.equipo3.raicessolidarias.model.Arbol;
import com.equipo3.raicessolidarias.service.ArbolServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/arbol")
public class ArbolRestController {
    private final ArbolServiceImpl arbolService;
    @PostMapping("/registrar")
    public ResponseEntity<Arbol> registrarArbol(@RequestBody Arbol arbol) {
        Arbol arbolRegistrado = arbolService.registrarArbol(arbol);
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
    public ResponseEntity<Arbol> actualizarArbol(@RequestBody Arbol arbol) {
        Arbol arbolActualizado= arbolService.actualizarArbol(arbol);
        return new ResponseEntity<>(arbolActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarArbol(@PathVariable Long id) {
        return new ResponseEntity<>(arbolService.eliminarArbol(id), HttpStatus.OK);
    }
}
