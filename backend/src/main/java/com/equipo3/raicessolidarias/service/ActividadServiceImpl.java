package com.equipo3.raicessolidarias.service;

import com.equipo3.raicessolidarias.dto.ActividadDTO;
import com.equipo3.raicessolidarias.model.Actividad;
import com.equipo3.raicessolidarias.repository.ActividadRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ActividadServiceImpl implements ActividadService {
    private final ActividadRepository actividadRepository;
    private final ObjectMapper mapper;


    @Override
    public ActividadDTO guardarActividad(ActividadDTO actividadDTO) {
        boolean actividadExistente = actividadRepository.existsByNombre(actividadDTO.getNombre());

        if (actividadExistente) {

            return null;
        } else {

            Actividad nuevaActividad = mapper.convertValue(actividadDTO, Actividad.class);
            Actividad actividadGuardada = actividadRepository.save(nuevaActividad);
            return mapper.convertValue(actividadGuardada, ActividadDTO.class);
        }
    }

    @Override
    public List<ActividadDTO> buscarActividadPorFecha(LocalDate fecha) {
        List<Actividad> actividades = actividadRepository.findAllByFecha(fecha);

        if (!actividades.isEmpty()) {
            return actividades.stream()
                    .map(actividad -> mapper.convertValue(actividad, ActividadDTO.class))
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Actividad> listarActividad() {
        return actividadRepository.findAll();
    }

    @Override
    public ActividadDTO actualizarActividad(Actividad actividadDTO, Long id) {
        boolean actividadExiste = actividadRepository.existsById(id);

        if (actividadExiste) {
            Actividad actividadExistente = actividadRepository.findById(id).get();

            // Actualizar los campos de la actividad existente con los datos de actividadDTO
            actividadExistente.setNombre(actividadDTO.getNombre());
            actividadExistente.setDescripcion(actividadDTO.getDescripcion());
            actividadExistente.setFecha(actividadDTO.getFecha());
            actividadExistente.setArbolesSembrados(actividadDTO.getArbolesSembrados());

            Actividad actividadActualizada = actividadRepository.save(actividadExistente);

            return mapper.convertValue(actividadActualizada, ActividadDTO.class);
        } else {

            return null;
        }
    }
    @Override
    public String eliminarActividadPorId(Long actividadId) {
        boolean actividadExiste = actividadRepository.existsById(actividadId);

        if (actividadExiste) {
            actividadRepository.deleteById(actividadId);
            return "La actividad ha sido eliminada.";
        } else {
            return "La actividad con el ID " + actividadId + " no existe.";
        }
    }

}
