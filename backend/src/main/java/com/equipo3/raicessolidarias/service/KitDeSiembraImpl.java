package com.equipo3.raicessolidarias.service;

import com.equipo3.raicessolidarias.model.KitDeSiembra;
import com.equipo3.raicessolidarias.repository.KitDeSiembraRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class KitDeSiembraImpl implements KitDeSiembraService {

    private final KitDeSiembraRepository kitDeSiembraRepository;
    @Override
    public KitDeSiembra registrarKitDeSiembra(KitDeSiembra kitDeSiembra) {
        Boolean kitExiste = kitDeSiembraRepository.existsByNombre(kitDeSiembra.getNombreKit());
        if(kitExiste) {
            return null;
        } else {
            return kitDeSiembraRepository.save(kitDeSiembra);
        }
    }

    @Override
    public KitDeSiembra buscarKitDeSiembraPorId(Long id) {
        Boolean kitExiste = kitDeSiembraRepository.existsById(id);
        if(kitExiste) {
            return kitDeSiembraRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public List<KitDeSiembra> listarKitsDeSiembra() {
        return kitDeSiembraRepository.findAll();
    }

    @Override
    public KitDeSiembra actualizarKitDeSiembra(KitDeSiembra kitDeSiembra) {
        Boolean kitExiste = kitDeSiembraRepository.existsById(kitDeSiembra.getId());
        if (kitExiste && kitDeSiembra != null) {
            return kitDeSiembraRepository.save(kitDeSiembra);
        } else {
            return null;
        }
    }

    @Override
    public String eliminarKitDeSiembra(Long id) {
        Boolean kitExiste = kitDeSiembraRepository.existsById(id);
        if(kitExiste) {
            kitDeSiembraRepository.deleteById(id);
            return "El kit de siembra ha sido eliminado.";
        } else {
            return "El kit de siembra no existe en la base de datos.";
        }
    }
}
