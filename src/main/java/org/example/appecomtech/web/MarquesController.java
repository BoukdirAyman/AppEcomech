package org.example.appecomtech.web;

import org.example.appecomtech.dao.entities.Produit;
import org.example.appecomtech.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

    @Controller
    public class MarquesController {

        @Autowired
        private ProduitService produitService;

        @GetMapping("/Apple")
        public String viewAppleProducts(Model model) {
            List<Produit> appleProducts = produitService.findByMarque("Apple");
            model.addAttribute("produits", appleProducts);
            return "Apple";
        }

        @GetMapping("/Samsung")
        public String viewSamsungProducts(Model model) {
            List<Produit> samsungProducts = produitService.findByMarque("Samsung");
            model.addAttribute("produits", samsungProducts);
            return "Samsung";
        }

        @GetMapping("/Huawei")
        public String viewHuaweiProducts(Model model) {
            List<Produit> huaweiProducts = produitService.findByMarque("Huawei");
            model.addAttribute("produits", huaweiProducts);
            return "Huawei";
        }



    }
