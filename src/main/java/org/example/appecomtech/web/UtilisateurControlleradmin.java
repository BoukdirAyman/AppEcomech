package org.example.appecomtech.web;

import org.example.appecomtech.dao.entities.Utilisateur;
import org.example.appecomtech.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/utilisateurs")
public class UtilisateurControlleradmin {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/ajouter")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "ajouterUtilisateur";
    }

    @PostMapping("/ajouter")
    public String ajouterUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
        utilisateurService.save(utilisateur);
        return "redirect:/utilisateurs/list";
    }


    ////
    @GetMapping("/list")
    public String afficherListeUtilisateurs(Model model) {
        List<Utilisateur> listeUtilisateurs = utilisateurService.findAll();
        model.addAttribute("listeUtilisateurs", listeUtilisateurs);
        return "gererutilisateurs";
    }

    @GetMapping("/details/{id}")
    public String afficherDetailsUtilisateur(@PathVariable("id") Long id, Model model) {
        Utilisateur utilisateur = utilisateurService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid utilisateur Id:" + id));
        model.addAttribute("utilisateur", utilisateur);
        return "detailsUtilisateur";
    }

    @GetMapping("/modifier/{id}")
    public String afficherFormulaireModification(@PathVariable("id") Long id, Model model) {
        Utilisateur utilisateur = utilisateurService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid utilisateur Id:" + id));
        model.addAttribute("utilisateur", utilisateur);
        return "modifierUtilisateur";
    }

    @PostMapping("/modifier/{id}")
    public String modifierUtilisateur(@PathVariable("id") Long id, @ModelAttribute("utilisateur") Utilisateur utilisateurModifie) {
        utilisateurService.save(utilisateurModifie);
        return "redirect:/utilisateurs/list";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimerUtilisateur(@PathVariable("id") Long id) {
        utilisateurService.deleteById(id);
        return "redirect:/utilisateurs/list";
    }
}








