package com.location.voiture.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marque;

    private String modele;
    private String immatriculation;
    private double prixParJour;
    private boolean disponibilite=true;

    @OneToMany(mappedBy = "voiture")
    private List<Location> locations;

}
