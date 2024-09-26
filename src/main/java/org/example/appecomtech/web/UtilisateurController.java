package org.example.appecomtech.web;

import org.example.appecomtech.dao.entities.Utilisateur;
import org.example.appecomtech.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.example.appecomtech.dao.entities.Utilisateur;



public class UtilisateurController {


    private UtilisateurService utilisateurService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        boolean isAuthenticated = utilisateurService.checkLogin(username, password);
        if (isAuthenticated) {
            return "redirect:/";
        } else {
            return "redirect:/erreur";
        }
    }

    @GetMapping("/Connexion")
    public String showLoginForm() {
        return "Connexion";
    }

    @GetMapping("/Inscription")
    public String showRegistrationForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "Inscription";
    }

    @PostMapping("/Inscription")
    public String registerUser(@ModelAttribute Utilisateur utilisateur) {
        utilisateurService.save(utilisateur);
        return "redirect:/Connexion";
    }

    @GetMapping("/email/{email}")
    public Utilisateur getUserByEmail(@PathVariable String email) {
        return utilisateurService.findByEmail(email);
    }

    @GetMapping("/nom/{nom}")
    public Utilisateur getUserByNom(@PathVariable String nom) {
        return utilisateurService.findByNom(nom);
    }
}


