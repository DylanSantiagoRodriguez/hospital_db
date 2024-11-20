package com.hospital.version1.controllers;

import com.hospital.version1.models.Medico;
import com.hospital.version1.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicosController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> getAllMedicos() {
        return medicoService.getAllMedicos();
    }

    @GetMapping("/{id}")
    public Medico getMedicoById(@PathVariable int id) {
        return medicoService.getMedicoById(id);
    }

    @PostMapping
    public Medico createMedico(@RequestBody Medico medico) {
        return medicoService.createMedico(medico);
    }

    @PutMapping("/{id}")
    public Medico updateMedico(@PathVariable int id, @RequestBody Medico medico) {
        return medicoService.updateMedico(id, medico);
    }

    @DeleteMapping("/{id}")
    public void deleteMedico(@PathVariable int id) {
        medicoService.deleteMedico(id);
    }
}
