package org.example.appecomtech.service;

import org.example.appecomtech.dao.entities.Utilisateur;
import org.example.appecomtech.dao.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public void save(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    public Utilisateur findByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    public Utilisateur findByNom(String nom) {
        return utilisateurRepository.findByNom(nom);
    }


    public boolean authenticate(String email, String password) {
        return utilisateurRepository.findByEmailAndPassword(email, password).isPresent();
    }

    public boolean checkLogin(String username, String password) {
        Utilisateur existingCreator = utilisateurRepository.findByNom(username);

            if (existingCreator.getMotDePasse().equals(password)) {

                return true;
            } else {
                System.out.println("Password not valid");
                return false;
            }

    }
}
