package com.location.voiture.repositories;

import com.location.voiture.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByClientId(Long id); // FIXED: use 'client' instead of 'UtilisateurId'
}
