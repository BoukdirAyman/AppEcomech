package org.example.appecomtech.web;

import org.example.appecomtech.dao.entities.Panier;
import org.example.appecomtech.dao.entities.Produit;
import org.example.appecomtech.dao.entities.Utilisateur;
import org.example.appecomtech.service.PanierService;
import org.example.appecomtech.service.ProduitService;
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

    @Autowired
    private ProduitService produitService; // Assurez-vous d'ajouter cette ligne


    @GetMapping("/viewpanier")
    public String viewCart(Model model, Principal principal) {
        Utilisateur utilisateur;
        if (principal == null) {
            utilisateur = new Utilisateur();
        } else {
            utilisateur = utilisateurService.findByNom(principal.getName());
        }
        List<Panier> panierItems = panierService.findByUtilisateurId(utilisateur.getId());
        model.addAttribute("panierItems", panierItems);
        double total = calculateTotal(panierItems);
        model.addAttribute("total", total);
        return "panier";
    }


    @PostMapping("/ajouter")
    public String addToCart(@RequestParam Long produitId, Principal principal) {
        if (principal != null) {
            Utilisateur utilisateur = utilisateurService.findByNom(principal.getName());
            Produit produit = produitService.findById(produitId)
                    .orElseThrow(() -> new IllegalArgumentException("Produit non trouvé"));

            Panier panierItem = new Panier();
            panierItem.setProduit(produit);
            panierItem.setUtilisateur(utilisateur);
            panierItem.setQuantite(1);

            panierService.save(panierItem);
        }

        return "redirect:/panier/viewpanier";
    }



    @PostMapping("/passer-commande")
    public String passerCommande(Principal principal) {
        if (principal == null) {
            return "redirect:/connexion";
        } else {
            return "redirect:/confirmation-commande";
        }
    }

    private double calculateTotal(List<Panier> panierItems) {
        double total = 0;
        for (Panier item : panierItems) {
            total += item.getProduit().getPrix() * item.getQuantite();
        }
        return total;
    }


    @PostMapping("/supprimer")
    public String removeFromCart(@RequestParam Long panierId) {
        panierService.deleteById(panierId);
        return "redirect:/panier/viewpanier";
    }
}
