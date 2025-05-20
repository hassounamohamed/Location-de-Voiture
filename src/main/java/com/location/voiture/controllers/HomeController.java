package com.location.voiture.controllers;

import com.location.voiture.entities.Voiture;
import com.location.voiture.services.VoitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HomeController {

    private final VoitureService voitureService;

    public HomeController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Voiture> voituresDisponibles = voitureService.getVoituresDisponibles();
        model.addAttribute("voituresDisponibles", voituresDisponibles);
        return "index";
    }

    @GetMapping("/location-page")
    public String locationPage() {
        return "location";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/reservations")
    public String reservations() {
        return "reservations";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}