package org.example.appecomtech.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recherche")
public class RechercheController {

    @GetMapping
    public String afficherPageRecherche() {
        return "Recherche";
    }
}
