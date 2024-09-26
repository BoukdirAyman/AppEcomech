package org.example.appecomtech.web;

import org.example.appecomtech.dao.entities.Produit;
import org.example.appecomtech.service.ProduitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @Value("/Users/aymanboukdir/Projects/Projet J2ee/APPECOMTECH/src/main/resources/static/image")

    private String uploadDir ;

    @GetMapping("/ajouter")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("produit", new Produit());
        return "ajouterProduit";
    }


    private static final Logger logger = LoggerFactory.getLogger(Produit.class);


    @PostMapping("/ajouter")
    public String ajouterProduits(@ModelAttribute("produit") Produit produit,
                                @RequestParam("imageFile") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String uniqueFilename = UUID.randomUUID().toString() + extension;
            Path uploadPath = Paths.get(uploadDir, uniqueFilename);
            Files.write(uploadPath, bytes);
            produit.setImage("/image/"+uniqueFilename);

        }
        produitService.save(produit);
        return "redirect:/produits/gererproduits";

    }


    @GetMapping("/gererproduits")
    public String afficherListeProduits(Model model) {
        List<Produit> listeProduits = produitService.findAll();
        model.addAttribute("listeProduits", listeProduits);
        return "gererproduit";
    }

    @GetMapping("/details/{id}")
    public String afficherDetailsProduit(@PathVariable("id") Long id, Model model) {
        Produit produit = produitService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid produit Id:" + id));
        model.addAttribute("produit", produit);
        return "detailsproduit";
    }

    @GetMapping("/modifier/{id}")
    public String afficherFormulaireModification(@PathVariable("id") Long id, Model model) {
        Produit produit = produitService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid produit Id:" + id));
        model.addAttribute("produit", produit);
        return "modifierproduit";
    }

    @PostMapping("/modifier/{id}")
    public String modifierProduit(@PathVariable("id") Long id,
                                  @ModelAttribute("produit") Produit produitModifie,
                                  @RequestParam("imageFile") MultipartFile file) {
        try {
            produitService.modifierProduitAvecImage(id, produitModifie, file);
        } catch (Exception e) {
            logger.error("Une erreur s'est produite : {}", e.getMessage(), e);
            return "redirect:/erreur";
        }
        return "redirect:/produits/gererproduits";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimerProduit(@PathVariable("id") Long id) {
        produitService.supprimerProduit(id);
        return "redirect:/produits/gererproduits";
    }

    @GetMapping("/allproduits")
    public String viewProducts(@RequestParam(name = "sort", required = false) String sort, Model model) {
        List<Produit> products;
        if ("ASC".equals(sort)) {
            products = produitService.findAllOrderByPrixAsc();
        } else if ("DESC".equals(sort)) {
            products = produitService.findAllOrderByPrixDesc();
        } else {
            products = produitService.findAll();
        }
        model.addAttribute("produits", products);
        return "liste_produits";
    }

}