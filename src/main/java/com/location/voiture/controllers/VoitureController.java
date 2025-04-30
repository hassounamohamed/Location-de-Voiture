package com.location.voiture.controllers;

import com.location.voiture.entities.Voiture;
import com.location.voiture.services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/voiture")
@CrossOrigin("*")
public class VoitureController {
    @Autowired
    private VoitureService voitureService;

    @GetMapping
    public List<Voiture> getVoitures() {
        return voitureService.getAllVoiture();
    }

    @GetMapping("/disponibles")
    public List<Voiture> getVoitureDisponibles() {
        return voitureService.getVoituresDisponibles();
    }

    @GetMapping("/{id}")
    public Optional<Voiture> getVoitureById(@PathVariable Long id) {
        return voitureService.getVoitureById(id);
    }

    @PostMapping
    public Voiture createVoiture(@RequestBody Voiture voiture) {
        return voitureService.saveVoiture(voiture);
    }

    @PutMapping("/{id}")
    public Voiture updateVoiture(@PathVariable Long id, @RequestBody Voiture updatedVoiture) {
        updatedVoiture.setId(id);
        return voitureService.saveVoiture(updatedVoiture);
    }

    @DeleteMapping("/{id}")
    public void deleteVoiture(@PathVariable Long id) {
        voitureService.deleteVoiture(id);
    }
}
