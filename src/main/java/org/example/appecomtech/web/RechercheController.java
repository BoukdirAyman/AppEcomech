package org.example.appecomtech.web;

import org.example.appecomtech.dao.entities.Produit;
import org.example.appecomtech.service.VotreServiceDeRecherche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/recherche")
public class RechercheController {

    private final VotreServiceDeRecherche serviceDeRecherche;

    @Autowired
    public RechercheController(VotreServiceDeRecherche serviceDeRecherche) {
        this.serviceDeRecherche = serviceDeRecherche;
    }

    @GetMapping
    public String afficherPageRecherche(@RequestParam("query") String termeRecherche, Model model) {

        List<Produit> resultats = serviceDeRecherche.rechercher(termeRecherche);


        model.addAttribute("resultats", resultats);


        return "Recherche";
    }
}
