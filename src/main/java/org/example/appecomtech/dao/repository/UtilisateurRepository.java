package org.example.appecomtech.dao.repository;

import org.example.appecomtech.dao.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmail(String email);
    Utilisateur findByNom(String nom);
    Optional<Utilisateur> findByEmailAndMotDePasse(String email, String motDePasse);
    // Ajoutez d'autres méthodes de recherche si nécessaire
}
