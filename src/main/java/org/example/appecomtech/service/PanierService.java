package org.example.appecomtech.service;

import lombok.Data;
import org.example.appecomtech.dao.entities.PanierItem;
import org.example.appecomtech.dao.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
public class PanierService {
    @Autowired
    private PanierRepository panierRepository;

    public List<PanierItem> findByUtilisateurId(Long utilisateurId) {
        return panierRepository.findByUtilisateurId(utilisateurId);
    }

    public PanierItem save(PanierItem panierItem) {
        return panierRepository.save(panierItem);
    }


}



