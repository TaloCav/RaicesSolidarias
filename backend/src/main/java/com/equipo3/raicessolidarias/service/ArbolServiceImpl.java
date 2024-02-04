package com.equipo3.raicessolidarias.service;

import com.equipo3.raicessolidarias.model.Arbol;
import com.equipo3.raicessolidarias.repository.ArbolRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ArbolServiceImpl implements ArbolService {
    private final ArbolRepository arbolRepository;
    @Override
    public Arbol registrarArbol(Arbol arbol) {
        Boolean arbolExiste = arbolRepository.existsByNombreCientifico(arbol.getNombreCientifico());
        if(arbolExiste) {
            return null;
        } else {
            return arbolRepository.save(arbol);
        }
    }

    @Override
    public Arbol buscarArbolPorId(Long id) {
        Boolean arbolExiste = arbolRepository.existsById(id);
        if(arbolExiste) {
            return arbolRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public List<Arbol> listarArboles() {
        return arbolRepository.findAll();
    }

    @Override
    public Arbol actualizarArbol(Arbol arbol) {
        Boolean arbolExiste = arbolRepository.existsById(arbol.getId());
        if (arbolExiste && arbol != null) {
            return arbolRepository.save(arbol);
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
