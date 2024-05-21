package org.example.appecomtech.dao.repository;

import org.example.appecomtech.dao.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmail(String email);
    Utilisateur findByNom(String nom);
    @Query(
            value = "select us from Utilisateur us WHERE us.email = ?1 AND us.motDePasse = ?2"
    )
    Optional<Utilisateur> findByEmailAndPassword(String email, String password);

}

