package org.example.appecomtech.web;


import org.example.appecomtech.dao.entities.Produit;
import org.example.appecomtech.dao.repository.ProduitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {


    private final ProduitRepository produitRepository;

    public HomeController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Produit> produits = produitRepository.findAll();
        model.addAttribute("produits", produits);
        return "Accueil";
    }


}