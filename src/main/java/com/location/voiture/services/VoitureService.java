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

    public List<Voiture> getVoituresDisponibles () {
        return voitureRepository.findByDisponibiliteTrue();
    }
    public boolean updatedVoiture(long id , Voiture updatedVoiture) throws Exception {
        if (id == 0) {
            throw new Exception();
            return false;
        }
        String sql= "update * from voiture into updatedVoiture where voiture.id=id ";
        return voitureService.saveVoiture(updatedVoiture);

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

}
