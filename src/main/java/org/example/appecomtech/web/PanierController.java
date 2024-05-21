package org.example.appecomtech.web;

import org.example.appecomtech.dao.entities.PanierItem;
import org.example.appecomtech.dao.entities.Utilisateur;
import org.example.appecomtech.service.PanierService;
import org.example.appecomtech.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/panier")
public class PanierController {
    @Autowired
    private PanierService panierService;

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public String viewCart(Model model, Principal principal) {
        Utilisateur utilisateur;
        if (principal == null) {
            utilisateur = new Utilisateur();
        } else {
            utilisateur = utilisateurService.findByNom(principal.getName());
        }
        List<PanierItem> panierItems = panierService.findByUtilisateurId(utilisateur.getId());
        model.addAttribute("panierItems", panierItems);
        return "panier";
    }

    @PostMapping("/ajouter")
    public String addToCart(@RequestParam Long produitId, Principal principal) {

        return "redirect:/panier";
    }

    @PostMapping("/passer-commande")
    public String passerCommande(Principal principal) {
        if (principal == null) {
            return "redirect:/connexion";
        } else {
            return "redirect:/confirmation-commande";
        }
    }

}
