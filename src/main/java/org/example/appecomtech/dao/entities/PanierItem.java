package org.example.appecomtech.dao.entities;

import jakarta.persistence.*;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Data


@Entity
public class PanierItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "panierItem")
    private Collection<Produit> produits;

    @ManyToOne
    private Utilisateur utilisateur;

    private int quantite;

    private String nom;

    private String description;

    private double prix;








    // Constructeurs, getters et setters

}
