package com.location.voiture.services;

import com.location.voiture.entities.Utilisateur;
import com.location.voiture.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    public Optional<Utilisateur> getUtilisateurByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }
    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
