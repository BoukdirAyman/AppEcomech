package org.example.appecomtech.web;

import org.example.appecomtech.dao.entities.Commande;
import org.example.appecomtech.dao.entities.Panier;
import org.example.appecomtech.dao.entities.Utilisateur;
import org.example.appecomtech.service.CommandeService;
import org.example.appecomtech.service.PanierService;
import org.example.appecomtech.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @Autowired
    private PanierService panierService;

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/confirmation")
    public String afficherConfirmationCommande(Model model, Principal principal) {
        Utilisateur utilisateur = utilisateurService.findByNom(principal.getName());
        List<Panier> panierItems = panierService.findByUtilisateurId(utilisateur.getId());
        double total = calculateTotal(panierItems);

        Commande commande = new Commande();
        commande.setUtilisateur(utilisateur);
        commande.setPaniers(panierItems);
        commande.setTotal(total);
        commandeService.save(commande);
        panierService.clearPanierByUtilisateurId(utilisateur.getId());

        model.addAttribute("commande", commande);
        return "confirmation-commande";
    }

    @PostMapping("/passer-commande")
    public String passerCommande(Principal principal) {
        if (principal == null) {
            return "redirect:/connexion";
        } else {
            return "redirect:/commande/confirmation";
        }
    }

    private double calculateTotal(List<Panier> panierItems) {
        double total = 0;
        for (Panier item : panierItems) {
            total += item.getProduit().getPrix() * item.getQuantite();
        }
        return total;
    }

}
