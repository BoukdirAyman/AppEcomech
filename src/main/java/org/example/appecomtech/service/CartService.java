package org.example.appecomtech.service;



import org.example.appecomtech.dao.entities.Produit;
import org.example.appecomtech.dao.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private ProduitRepository produitRepository;

    public void addProductToCart(Long productId) {
        Produit produit = produitRepository.findById(productId).orElseThrow(() -> new RuntimeException("Produit non trouvé"));

    }
}
