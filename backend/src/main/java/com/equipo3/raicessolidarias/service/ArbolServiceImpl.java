package com.equipo3.raicessolidarias.service;

import com.equipo3.raicessolidarias.dto.ArbolDTO;
import com.equipo3.raicessolidarias.model.Arbol;
import com.equipo3.raicessolidarias.repository.ArbolRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ArbolServiceImpl implements ArbolService {
    private final ArbolRepository arbolRepository;
    private final ObjectMapper mapper;
    @Override
    public Arbol registrarArbol(Arbol arbol) {
        // Verificar si ya existe un árbol con el mismo nombre científico
        Boolean arbolExiste = arbolRepository.existsByNombreCientifico(arbol.getNombreCientifico());

        if (arbolExiste) {
            return null;
        } else {

            Arbol arbolAGuardar = mapper.convertValue(arbol, Arbol.class);

            Arbol arbolGuardado = arbolRepository.save(arbolAGuardar);


            return arbolGuardado;
        }
    }

    @Override
    public Arbol buscarArbolPorId(Long id) {
        Boolean arbolExiste = arbolRepository.existsById(id);
        if (arbolExiste) {
            return arbolRepository.findById(id).orElse(null);
        } else {
            return null;
        }
    }
    @Override
    public ArbolDTO buscarArbolPorNombreCientifico(String nombreCientifico) {
        return null;
    }

    @Override
    public List<Arbol> listarArboles() {
        return arbolRepository.findAll();
    }

    @Override
    public ArbolDTO actualizarArbol(ArbolDTO arbolDTO, Long id) {
        Boolean arbolExiste = arbolRepository.existsById(id);

        if (arbolExiste) {

            Arbol arbolExistente = arbolRepository.findById(id).get();

            arbolExistente.setNombreComun(arbolDTO.getNombreComun());
            arbolExistente.setNombreCientifico(arbolDTO.getNombreCientifico());
            arbolExistente.setTipo(arbolDTO.getTipo());

            // Guardar el árbol actualizado en la base de datos
            Arbol arbolActualizado = arbolRepository.save(arbolExistente);

            // Convertir el árbol actualizado a un DTO de árbol y devolverlo
            return mapper.convertValue(arbolActualizado, ArbolDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public String eliminarArbol(Long id) {
        Boolean arbolExiste = arbolRepository.existsById(id);
        if(arbolExiste) {
            arbolRepository.deleteById(id);
            return "El árbol ha sido eliminado.";
        } else {
            return "El árbol no existe en la base de datos.";
        }
    }
}
