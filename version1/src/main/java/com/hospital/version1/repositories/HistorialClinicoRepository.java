package com.hospital.version1.repositories;

import com.hospital.version1.models.HistorialClinico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistorialClinicoRepository extends JpaRepository<HistorialClinico, Long> {
    List<HistorialClinico> findByPacienteId(Long pacienteId);
}
