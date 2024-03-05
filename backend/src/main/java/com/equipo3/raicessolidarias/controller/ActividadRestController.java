package com.equipo3.raicessolidarias.controller;

import com.equipo3.raicessolidarias.dto.ActividadDTO;
import com.equipo3.raicessolidarias.model.Actividad;
import com.equipo3.raicessolidarias.service.ActividadServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/actividad")
public class ActividadRestController {

    private final ActividadServiceImpl actividadService;

    @PostMapping("/registrar")
    public ResponseEntity<ActividadDTO> guardarActividad(@RequestBody ActividadDTO actividadDTO) {
        ActividadDTO usuarioRegistrado = actividadService.guardarActividad(actividadDTO);
        return new ResponseEntity<>(usuarioRegistrado, HttpStatus.CREATED);


    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<ActividadDTO>> buscarActividadPorFecha(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        List<ActividadDTO> actividadesEnFecha = actividadService.buscarActividadPorFecha(fecha);

        if (!actividadesEnFecha.isEmpty()) {
            return new ResponseEntity<>(actividadesEnFecha, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Actividad>> listarActividades() {
        List<Actividad> listaDeActividades = actividadService.listarActividad();
        return new ResponseEntity<>(listaDeActividades, HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ActividadDTO> actualizarActividad(@RequestBody Actividad actividadDTO, @RequestParam Long id) {
        ActividadDTO actividadActualizada = actividadService.actualizarActividad(actividadDTO, id);

        if (actividadActualizada != null) { // Si la actividad se actualizó correctamente
            return new ResponseEntity<>(actividadActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Devuelve NOT FOUND si la actividad no se encuentra
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarActividadPorId(@PathVariable Long id) {
        actividadService.eliminarActividadPorId(id);
        return new ResponseEntity<>("La actividad fue eliminada", HttpStatus.OK);
    }


}
