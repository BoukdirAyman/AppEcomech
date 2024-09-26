package org.example.appecomtech.dao.repository;

import org.example.appecomtech.dao.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByCategorie(String categorieNom);

    List<Produit> findByMarque(String marque);

    List<Produit> findAllByOrderByPrixAsc();

    List<Produit> findAllByOrderByPrixDesc();

    List<Produit> findByNomContainingIgnoreCase(String termeRecherche);

}
