// CommandeService.java
package org.example.appecomtech.service;

import org.example.appecomtech.dao.entities.Commande;
import org.example.appecomtech.dao.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;

    public List<Commande> findByUtilisateurId(Long utilisateurId) {
        return commandeRepository.findByUtilisateurId(utilisateurId);
    }

    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }
}
