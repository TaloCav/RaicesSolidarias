package com.equipo3.raicessolidarias.service;

import com.equipo3.raicessolidarias.dto.ActividadDTO;
import com.equipo3.raicessolidarias.dto.UsuarioDTO;
import com.equipo3.raicessolidarias.model.Actividad;

import java.time.LocalDate;
import java.util.List;

public interface ActividadService {

    ActividadDTO guardarActividad(ActividadDTO actividadParaGuardarDTO);
    public List<ActividadDTO> buscarActividadPorFecha(LocalDate fecha);
    List<Actividad> listarActividad();

    ActividadDTO actualizarActividad(Actividad actividadDTO, Long id);

    String eliminarActividadPorId(Long actividadId);



}
