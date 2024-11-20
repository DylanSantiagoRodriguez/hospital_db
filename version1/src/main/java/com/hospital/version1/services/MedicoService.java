package com.hospital.version1.services;

import com.hospital.version1.models.Medico;

import java.util.List;

public interface MedicoService {
    List<Medico> getAllMedicos();
    Medico getMedicoById(int id);
    Medico createMedico(Medico medico);
    Medico updateMedico(int id, Medico medico);
    void deleteMedico(int id);
}
