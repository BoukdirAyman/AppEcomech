package org.example.appecomtech.service;

import org.example.appecomtech.dao.entities.Utilisateur;
import org.example.appecomtech.dao.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public void save(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    public Utilisateur findByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    public Utilisateur findByNom(String nom) {
        return utilisateurRepository.findByNom(nom);
    }

    public boolean authenticate(String email, String motDePasse) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmailAndMotDePasse(email, motDePasse);
        return utilisateur.isPresent();
    }

    public boolean checkLogin(String username, String password) {
        Utilisateur existingUser = utilisateurRepository.findByNom(username);
        if (existingUser != null && existingUser.getMotDePasse().equals(password)) {
            return true;
        } else {
            System.out.println("Password not valid or user not found");
            return false;
        }
    }

    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> findById(Long id) {
        return utilisateurRepository.findById(id);
    }

    public void deleteById(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
