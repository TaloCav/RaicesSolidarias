package com.equipo3.raicessolidarias.service;

import com.equipo3.raicessolidarias.model.ERol;
import com.equipo3.raicessolidarias.model.Rol;
import com.equipo3.raicessolidarias.repository.RolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RolService {

    private final RolRepository rolRepository;

    public Optional<Rol> buscarRolPorNombre(ERol nombre) {
        return rolRepository.findByNombre(nombre);
    }
}