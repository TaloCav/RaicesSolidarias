package com.equipo3.raicessolidarias.service;


import com.equipo3.raicessolidarias.model.Arbol;

import java.util.List;

public interface ArbolService {
    Arbol registrarArbol(Arbol arbol);
    Arbol buscarArbolPorId(Long id);
    List<Arbol> listarArboles();
    Arbol actualizarArbol(Arbol arbol);
    String eliminarArbol(Long id);
}
