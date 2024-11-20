package com.hospital.version1.services.impl;

import com.hospital.version1.models.Cita;
import com.hospital.version1.repositories.CitaRepository;
import com.hospital.version1.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Override
    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    @Override
    public Cita getCitaById(int id) {
        return citaRepository.findById(id).orElse(null);
    }

    @Override
    public Cita createCita(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public Cita updateCita(int id, Cita cita) {
        Cita existingCita = citaRepository.findById(id).orElse(null);
        if (existingCita != null) {
            existingCita.setFecha(cita.getFecha());
            existingCita.setHora(cita.getHora());
            existingCita.setEstado(cita.getEstado());
            return citaRepository.save(existingCita);
        }
        return null;
    }

    @Override
    public void deleteCita(int id) {
        citaRepository.deleteById(id);
    }
}
