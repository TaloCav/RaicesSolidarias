package com.equipo3.raicessolidarias.controller;

import com.equipo3.raicessolidarias.model.KitDeSiembra;
import com.equipo3.raicessolidarias.service.KitDeSiembraImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/kitdesiembra")
public class KitDeSiembraRestController {
    private final KitDeSiembraImpl kitDeSiembraService;
    @PostMapping("/registrar")
    public ResponseEntity<KitDeSiembra> registrarKitDeSiembra(@RequestBody KitDeSiembra kitDeSiembra) {
        KitDeSiembra kitRegistrado = kitDeSiembraService.registrarKitDeSiembra(kitDeSiembra);
        return new ResponseEntity<>(kitRegistrado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KitDeSiembra> buscarKitDeSiembraPorId(@PathVariable Long id) {
        KitDeSiembra kitBuscado = kitDeSiembraService.buscarKitDeSiembraPorId(id);
        return new ResponseEntity<>(kitBuscado, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<KitDeSiembra>> listarKitsDeSiembra() {
        List<KitDeSiembra> listaDeKits = kitDeSiembraService.listarKitsDeSiembra();
        return new ResponseEntity<>(listaDeKits, HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<KitDeSiembra> actualizarKitDeSiembra(@RequestBody KitDeSiembra kitDeSiembra) {
        KitDeSiembra kitActualizado= kitDeSiembraService.actualizarKitDeSiembra(kitDeSiembra);
        return new ResponseEntity<>(kitActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarKitDeSiembra(@PathVariable Long id) {
        return new ResponseEntity<>(kitDeSiembraService.eliminarKitDeSiembra(id), HttpStatus.OK);
    }
}
