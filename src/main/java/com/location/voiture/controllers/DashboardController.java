package com.location.voiture.controllers;

import org.springframework.ui.Model;
import com.location.voiture.services.LocationService;
import com.location.voiture.services.UtilisateurService;
import com.location.voiture.services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @Autowired
    private VoitureService voitureService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/dashboard")
    public String ShowDashboard(Model model) {
        model.addAttribute("totalVoitures", voitureService.getAllVoiture().size());
        model.addAttribute("voituresDisponibles", voitureService.getVoituresDisponibles().size());
        model.addAttribute("totalClients", utilisateurService.getAllUtilisateurs().size());
        model.addAttribute("locationsActives", locationService.getAllLocations().size());
        model.addAttribute("voitures", voitureService.getAllVoiture());
        return "dashboard";
    }
}