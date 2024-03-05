package com.equipo3.raicessolidarias.controller;

import com.equipo3.raicessolidarias.cloud.S3Service;
import com.equipo3.raicessolidarias.dto.ArbolDTO;
import com.equipo3.raicessolidarias.model.Arbol;
import com.equipo3.raicessolidarias.service.ArbolServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/arbol")
public class ArbolRestController {
    private final ArbolServiceImpl arbolService;
    private final S3Service s3Service;
    @PostMapping("/registrar")
    public ResponseEntity<Arbol> registrarArbol(@RequestPart("file") MultipartFile file,
                                                    @RequestPart("arbol") Arbol nuevoArbol) {
        try {
            String filename = file.getOriginalFilename();
            String contentType = file.getContentType(); // Obtener el tipo de contenido del archivo

            // Verificar el tipo de contenido y establecer el tipo de contenido correspondiente
            String imageUrl;
            if (contentType != null && contentType.equals("image/jpeg")) {
                imageUrl = s3Service.uploadFile(filename, file.getInputStream(), "image/jpeg");
            } else if (contentType != null && contentType.equals("image/png")) {
                imageUrl = s3Service.uploadFile(filename, file.getInputStream(), "image/png");
            } else {
                // Tipo de contenido no compatible
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            nuevoArbol.setImagen(imageUrl); // Guardar la URL del archivo en el campo de imagen
            Arbol arbolGuardado = arbolService.registrarArbol(nuevoArbol); // Guardar producto en la base de datos
            return new ResponseEntity(arbolGuardado, HttpStatus.CREATED);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Manejar error de subida de imagen
        }
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
