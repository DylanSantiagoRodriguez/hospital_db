package com.hospital.version1.repositories;

import com.hospital.version1.models.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {

    List<Cita> findByPacienteId(int pacienteId);

    List<Cita> findByMedicoId(int medicoId);

    List<Cita> findByFechaBetween(String fechaInicio, String fechaFin);

    List<Cita> findByEstado(String estado);

    List<Cita> findByPacienteIdAndMedicoId(int pacienteId, int medicoId);
}
