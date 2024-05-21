package org.example.appecomtech.dao.repository;



import org.example.appecomtech.dao.entities.PanierItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PanierItemRepository extends JpaRepository<PanierItem, Long> {
    List<PanierItem> findByUtilisateurId(Long utilisateurId);
}
