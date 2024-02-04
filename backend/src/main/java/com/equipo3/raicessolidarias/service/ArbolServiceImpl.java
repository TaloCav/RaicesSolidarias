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
        return null;
    }

    @Override
    public Arbol buscarArbolPorId(Long id) {
        return null;
    }

    @Override
    public List<Arbol> listarArboles() {
        return null;
    }

    @Override
    public Arbol actualizarArbol(Arbol arbol) {
        return null;
    }

    @Override
    public String eliminarArbol(Long id) {
        return null;
    }
}
