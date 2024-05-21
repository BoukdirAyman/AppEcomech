package org.example.appecomtech.dao.repository;

import org.example.appecomtech.dao.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findByUtilisateurId(Long utilisateurId);
}
