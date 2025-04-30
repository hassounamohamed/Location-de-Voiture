package com.location.voiture.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long UtilisateurId;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    @ManyToOne
    private Utilisateur client;

    @ManyToOne
    private  Voiture voiture;
}
