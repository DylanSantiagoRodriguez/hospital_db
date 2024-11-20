package com.hospital.version1.services;

import com.hospital.version1.models.Paciente;

import java.util.List;

public interface PacienteService {
    List<Paciente> getAllPacientes();
    Paciente getPacienteById(int id);
    Paciente createPaciente(Paciente paciente);
    Paciente updatePaciente(int id, Paciente paciente);
    void deletePaciente(int id);
}
