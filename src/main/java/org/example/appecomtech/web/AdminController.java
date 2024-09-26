package org.example.appecomtech.web;

import org.example.appecomtech.dao.entities.Commande;
import org.example.appecomtech.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CommandeService commandeService;

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
    @GetMapping("/commande-admin")
    public String afficherCommandes(Model model) {
        List<Commande> commandes = commandeService.getAllCommandes(); // Implémentez cette méthode dans le service
        model.addAttribute("commandes", commandes);
        return "commande-admin"; // Nom de la page HTML
    }
}
