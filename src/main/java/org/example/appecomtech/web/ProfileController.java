package org.example.appecomtech.web;

import org.example.appecomtech.dao.entities.Utilisateur;
import org.example.appecomtech.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public ProfileController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/profiles")
    public String showProfile(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        Utilisateur utilisateur = utilisateurService.findByNom(currentUserName);
        if (utilisateur != null) {
            model.addAttribute("utilisateur", utilisateur);
        }

        return "profile";
    }
}
