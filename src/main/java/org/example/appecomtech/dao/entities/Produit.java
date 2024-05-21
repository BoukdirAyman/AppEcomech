package org.example.appecomtech.dao.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Entity
@NoArgsConstructor @AllArgsConstructor
@Table(name = "Produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String description;

    private double prix;

    private int quantiteEnStock; // Ajout de l'attribut quantité en stock

    private String categorie;

    private String marque;
    @ManyToOne
    private PanierItem panierItem;

    @Column(name = "image")
    private String image;



}
