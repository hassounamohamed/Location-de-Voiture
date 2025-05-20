package com.location.voiture.services;
import com.location.voiture.services.VoitureService;
import com.location.voiture.entities.Voiture;
import com.location.voiture.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoitureService {
    @Autowired
    private VoitureRepository voitureRepository;

    public List<Voiture> getAllVoiture() {
        return voitureRepository.findAll();
    }

    public boolean updatedVoiture(long id, Voiture updatedVoiture) throws Exception {
        Optional<Voiture> existingVoiture = voitureRepository.findById(id);
        if (existingVoiture.isPresent()) {
            updatedVoiture.setId(id); // s'assurer que l’ID reste le même
            voitureRepository.save(updatedVoiture);
            return true;
        } else {
            throw new Exception("Voiture with ID " + id + " not found.");
        }
    }


    public Optional<Voiture> getVoitureById(Long id) {
        return voitureRepository.findById(id);
    }

    public Voiture saveVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }
    public void deleteVoiture(Long id) {
        voitureRepository.deleteById(id);
    }

    public List<Voiture> getVoituresDisponibles() {
        return voitureRepository.findByDisponibiliteTrue();
    }
    public long countAllVoitures() {
        return voitureRepository.count();
    }

    public long countAvailableVoitures() {
        return voitureRepository.countByDisponibiliteTrue();
    }

    public List<Voiture> getRecentVoitures(int limit) {
        return voitureRepository.findTopNByOrderByIdDesc(limit);
    }

}
