package com.hospital.version1.services;

import com.hospital.version1.models.HistorialClinico;
import com.hospital.version1.repositories.HistorialClinicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialClinicoService {

    @Autowired
    private HistorialClinicoRepository historialClinicoRepository;

    /**
     * Obtiene el historial clínico de un paciente por su ID.
     * 
     * @param pacienteId El ID del paciente.
     * @return Lista de historiales clínicos del paciente.
     */
    public List<HistorialClinico> obtenerHistorialPorPaciente(Long pacienteId) {
        return historialClinicoRepository.findByPacienteId(pacienteId);
    }

    /**
     * Obtiene un historial clínico por su ID.
     * 
     * @param id El ID del historial clínico.
     * @return El historial clínico encontrado, o vacío si no se encuentra.
     */
    public Optional<HistorialClinico> obtenerHistorialPorId(Long id) {
        return historialClinicoRepository.findById(id);
    }

    /**
     * Guarda un nuevo historial clínico.
     * 
     * @param historialClinico El historial clínico a guardar.
     * @return 
     */
    public HistorialClinico guardarHistorialClinico(HistorialClinico historialClinico) {
        return historialClinicoRepository.save(historialClinico);
    }

    public void eliminarHistorialClinico(Long id) {
        historialClinicoRepository.deleteById(id);
    }
}
