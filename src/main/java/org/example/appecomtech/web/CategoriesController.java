package org.example.appecomtech.web;

import org.example.appecomtech.dao.entities.Produit;
import org.example.appecomtech.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoriesController {

    @Autowired
    private ProduitService produitService;

    @Controller
    @RequestMapping("/Smartphones")
    public class SmartphoneController {
        @GetMapping
        public String viewSmartphones(Model model) {
            List<Produit> smartphones = produitService.findByCategorie("Smartphone");
            model.addAttribute("produits", smartphones);
            return "smartphones";
        }
    }

    @Controller
    @RequestMapping("/Accessoires")
    public class AccessoireController {
        @GetMapping
        public String viewAccessoires(Model model) {
            List<Produit> accessoires = produitService.findByCategorie("Accessoires");
            model.addAttribute("produits", accessoires);
            return "accessoires";
        }
    }

    @Controller
    @RequestMapping("Tablettes")
    public class TabletteController {
        @GetMapping
        public String viewTablettes(Model model) {
            List<Produit> tablettes = produitService.findByCategorie("tablettes");
            model.addAttribute("produits", tablettes);
            return "tablettes";
        }
    }
}
