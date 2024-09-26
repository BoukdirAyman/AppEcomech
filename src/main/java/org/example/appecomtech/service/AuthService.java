package org.example.appecomtech.service;

import org.apache.catalina.User;
import org.example.appecomtech.dao.entities.Utilisateur;
import org.example.appecomtech.dao.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UtilisateurRepository utilisateurRepository; // Assuming you have a UtilisateurRepository to interact with user data

    public boolean authenticate(String email, String motDePasse) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur != null && utilisateur.getMotDePasse().equals(motDePasse)) {
            return true; // Authentication successful
        }
        return false; // Authentication failed
    }
}
