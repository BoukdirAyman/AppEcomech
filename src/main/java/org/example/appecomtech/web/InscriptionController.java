package org.example.appecomtech.web;

import org.example.appecomtech.dao.entities.Utilisateur;
import org.example.appecomtech.dao.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InscriptionController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping("/Inscription")
    public String afficherFormulaireInscription(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "Inscription";
    }

    @PostMapping("/Inscription")
    public String traiterFormulaireInscription(@ModelAttribute Utilisateur utilisateur, Model model) {
        utilisateurRepository.save(utilisateur);
        return "redirect:/inscription-success";
    }

    @GetMapping("/inscription-success")
    public String afficherInscriptionSuccess() {
        return "inscription-success";
    }
}
