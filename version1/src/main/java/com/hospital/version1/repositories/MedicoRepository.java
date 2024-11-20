package com.hospital.version1.repositories;

import com.hospital.version1.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    List<Medico> findByEspecialidad(String especialidad);

    List<Medico> findByNombre(String nombre);

    List<Medico> findByApellido(String apellido);

    long countByEspecialidad(String especialidad);
}
