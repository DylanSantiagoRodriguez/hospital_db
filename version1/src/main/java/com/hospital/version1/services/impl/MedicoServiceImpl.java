package com.hospital.version1.services.impl;

import com.hospital.version1.models.Medico;
import com.hospital.version1.repositories.MedicoRepository;
import com.hospital.version1.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico getMedicoById(int id) {
        return medicoRepository.findById(id).orElse(null);
    }

    @Override
    public Medico createMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public Medico updateMedico(int id, Medico medico) {
        Medico existingMedico = medicoRepository.findById(id).orElse(null);
        if (existingMedico != null) {
            existingMedico.setNombre(medico.getNombre());
            existingMedico.setApellido(medico.getApellido());
            existingMedico.setEspecialidad(medico.getEspecialidad());
            existingMedico.setTelefono(medico.getTelefono());
            existingMedico.setEmail(medico.getEmail());
            return medicoRepository.save(existingMedico);
        }
        return null;
    }

    @Override
    public void deleteMedico(int id) {
        medicoRepository.deleteById(id);
    }
}
