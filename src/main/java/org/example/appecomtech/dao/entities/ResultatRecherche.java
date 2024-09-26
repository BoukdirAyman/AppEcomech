package org.example.appecomtech.dao.entities;


import lombok.AllArgsConstructor;

@AllArgsConstructor

public class ResultatRecherche {
    private String nom;

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
