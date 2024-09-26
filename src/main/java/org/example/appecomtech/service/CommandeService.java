package org.example.appecomtech.service;

import org.example.appecomtech.dao.entities.Commande;
import org.example.appecomtech.dao.entities.Panier;
import org.example.appecomtech.dao.repository.CommandeRepository;
import org.example.appecomtech.dao.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;

    private PanierRepository panierRepository;

    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }


    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public void clearPanierByUtilisateurId(Long utilisateurId) {

        List<Panier> paniers = panierRepository.findByUtilisateurId(utilisateurId);
        panierRepository.deleteAll(paniers);
    }


    public Optional<Commande> findById(Long id) {
        return commandeRepository.findById(id);
    }


}
