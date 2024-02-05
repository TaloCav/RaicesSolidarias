package com.equipo3.raicessolidarias.service;

import com.equipo3.raicessolidarias.model.KitDeSiembra;

import java.util.List;

public interface KitDeSiembraService {
    KitDeSiembra registrarKitDeSiembra(KitDeSiembra kitDeSiembra);
    KitDeSiembra buscarKitDeSiembraPorId(Long id);
    List<KitDeSiembra> listarKitsDeSiembra();
    KitDeSiembra actualizarKitDeSiembra(KitDeSiembra kitDeSiembra);
    String eliminarKitDeSiembra(Long id);
}
