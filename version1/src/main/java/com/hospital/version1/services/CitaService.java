package com.hospital.version1.services;

import com.hospital.version1.models.Cita;

import java.util.List;

public interface CitaService {
    List<Cita> getAllCitas();
    Cita getCitaById(int id);
    Cita createCita(Cita cita);
    Cita updateCita(int id, Cita cita);
    void deleteCita(int id);
}
