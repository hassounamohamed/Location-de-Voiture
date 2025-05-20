package com.location.voiture.repositories;

import com.location.voiture.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
    List<Voiture> findByDisponibiliteTrue();


}
