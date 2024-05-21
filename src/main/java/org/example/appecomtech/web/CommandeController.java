package org.example.appecomtech.web;

import org.example.appecomtech.dao.entities.Commande;
import org.example.appecomtech.dao.entities.Utilisateur;
import org.example.appecomtech.service.CommandeService;
import org.example.appecomtech.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/commandes")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public String listOrders(Model model, Principal principal) {
        Utilisateur utilisateur = utilisateurService.findByEmail(principal.getName());
        if (utilisateur != null) {
            List<Commande> commandes = commandeService.findByUtilisateurId(utilisateur.getId());
            model.addAttribute("Commande", commandes);
        }
        return "Commande";
    }

    @PostMapping
    public String placeOrder(@ModelAttribute Commande commande, Principal principal) {
        Utilisateur utilisateur = utilisateurService.findByEmail(principal.getName());
        if (utilisateur != null) {
            commande.setUtilisateur(utilisateur);
            commandeService.save(commande);
        }
        return "redirect:/Commande";
    }

}
