package org.example.appecomtech.service;

import org.example.appecomtech.dao.entities.Panier;
import org.example.appecomtech.dao.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.appecomtech.dao.entities.Produit;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Service
public class PanierService {
    @Autowired
    private PanierRepository panierRepository;

    public List<Panier> findByUtilisateurId(Long utilisateurId) {
        return panierRepository.findByUtilisateurId(utilisateurId);
    }

    @Autowired
    private ProduitService produitService;

    @GetMapping("/details/{id}")
    public String afficherDetailsProduit(@PathVariable("id") Long id, Model model) {
        Produit produit = produitService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid produit Id:" + id));
        model.addAttribute("produit", produit);
        return "detailsproduit";
    }


    public Panier save(Panier panierItem) {
        return panierRepository.save(panierItem);
    }

    public void deleteById(Long id) {
        panierRepository.deleteById(id);
    }



    public void clearPanierByUtilisateurId(Long utilisateurId) {
        List<Panier> paniers = panierRepository.findByUtilisateurId(utilisateurId);
        panierRepository.deleteAll(paniers);
    }
}




