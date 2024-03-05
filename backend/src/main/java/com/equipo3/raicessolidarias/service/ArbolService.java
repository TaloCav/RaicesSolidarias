package com.equipo3.raicessolidarias.service;


import com.equipo3.raicessolidarias.dto.ArbolDTO;
import com.equipo3.raicessolidarias.model.Arbol;

import java.util.List;

public interface ArbolService {
    public Arbol registrarArbol(Arbol arbol) ;
    Arbol buscarArbolPorId(Long id);
    ArbolDTO buscarArbolPorNombreCientifico(String nombreCientifico);

    List<Arbol> listarArboles();
    ArbolDTO actualizarArbol(ArbolDTO arbolDTO, Long id);
    String eliminarArbol(Long id);
}
