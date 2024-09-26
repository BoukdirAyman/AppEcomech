package org.example.appecomtech.dao.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private List<Panier> paniers;

    private double total;

    private String status;


    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;
}