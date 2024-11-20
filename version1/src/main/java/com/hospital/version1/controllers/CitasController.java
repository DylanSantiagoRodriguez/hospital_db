package com.hospital.version1.controllers;

import com.hospital.version1.models.Cita;
import com.hospital.version1.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitasController {

    @Autowired
    private CitaService citaService;

    @GetMapping
    public List<Cita> getAllCitas() {
        return citaService.getAllCitas();
    }

    @GetMapping("/{id}")
    public Cita getCitaById(@PathVariable int id) {
        return citaService.getCitaById(id);
    }

    @PostMapping
    public Cita createCita(@RequestBody Cita cita) {
        return citaService.createCita(cita);
    }

    @PutMapping("/{id}")
    public Cita updateCita(@PathVariable int id, @RequestBody Cita cita) {
        return citaService.updateCita(id, cita);
    }

    @DeleteMapping("/{id}")
    public void deleteCita(@PathVariable int id) {
        citaService.deleteCita(id);
    }
}
