package org.example.appecomtech.service;

import org.example.appecomtech.dao.entities.Produit;
import org.example.appecomtech.dao.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> findAllOrderByPrixAsc() {
        return produitRepository.findAllByOrderByPrixAsc();
    }

    public List<Produit> findAllOrderByPrixDesc() {
        return produitRepository.findAllByOrderByPrixDesc();
    }

    public List<Produit> findByCategorie(String categorie) {
        return produitRepository.findByCategorie(categorie);
    }

    public List<Produit> findByMarque(String marque) {
        return produitRepository.findByMarque(marque);
    }

    public Optional<Produit> findById(Long id) {
        return produitRepository.findById(id);
    }

    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    public void ajouterProduitAvecImage(Produit produit){

        produitRepository.save(produit);
    }

    public void modifierProduitAvecImage(Long id, Produit produitModifie, MultipartFile file) throws IOException {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if (optionalProduit.isPresent()) {
            Produit produit = optionalProduit.get();
            produit.setNom(produitModifie.getNom());
            produit.setDescription(produitModifie.getDescription());
            produit.setPrix(produitModifie.getPrix());
            produit.setQuantiteEnStock(produitModifie.getQuantiteEnStock());

            produitRepository.save(produit);
        }
    }

    public void supprimerProduit(Long id) {
        produitRepository.deleteById(id);
    }
}
