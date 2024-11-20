package com.hospital.version1.services.impl;

import com.hospital.version1.models.Paciente;
import com.hospital.version1.repositories.PacienteRepository;
import com.hospital.version1.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente getPacienteById(int id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public Paciente createPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente updatePaciente(int id, Paciente paciente) {
        Paciente existingPaciente = pacienteRepository.findById(id).orElse(null);
        if (existingPaciente != null) {
            existingPaciente.setNombre(paciente.getNombre());
            existingPaciente.setApellido(paciente.getApellido());
            existingPaciente.setFechaNacimiento(paciente.getFechaNacimiento());
            existingPaciente.setTelefono(paciente.getTelefono());
            existingPaciente.setDireccion(paciente.getDireccion());
            return pacienteRepository.save(existingPaciente);
        }
        return null;
    }

    @Override
    public void deletePaciente(int id) {
        pacienteRepository.deleteById(id);
    }
}
