package org.example.appecomtech.service;

import org.example.appecomtech.dao.entities.Produit;
import org.example.appecomtech.dao.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotreServiceDeRecherche {

    private final ProduitRepository produitRepository;

    @Autowired
    public VotreServiceDeRecherche(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public List<Produit> rechercher(String termeRecherche) {
        // Utilisez votre repository pour rechercher les produits correspondant au terme de recherche
        List<Produit> resultats = produitRepository.findByNomContainingIgnoreCase(termeRecherche);
        return resultats;
    }
}
