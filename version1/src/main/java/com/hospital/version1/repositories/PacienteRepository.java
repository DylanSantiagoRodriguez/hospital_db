package com.hospital.version1.repositories;

import com.hospital.version1.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByApellido(String apellido);
    
    List<Paciente> findByNombre(String nombre);

    List<Paciente> findByFechaNacimiento(String fechaNacimiento);
}
