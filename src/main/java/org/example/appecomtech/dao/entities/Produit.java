package org.example.appecomtech.dao.entities;


import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Entity
@NoArgsConstructor @AllArgsConstructor
@Table(name = "Produit")
@Data
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
    private Panier panier;

    @Column(name = "image")
    private String image;






}