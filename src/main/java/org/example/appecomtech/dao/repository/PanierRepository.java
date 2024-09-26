//package org.example.appecomtech.dao.repository;
//
//import org.example.appecomtech.dao.entities.Panier;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//
//public interface PanierRepository extends JpaRepository<Panier, Long> {
//
//    @Query("SELECT c FROM Panier c WHERE c.utilisateur.id = ?1")
//    Panier findActivePanier(int utilisateurId);
//
//
//
//    List<Panier> findByUtilisateurId(Long utilisateurId);
//}

package org.example.appecomtech.dao.repository;

import org.example.appecomtech.dao.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {
    List<Panier> findByUtilisateurId(Long utilisateurId);

    void deleteById(Long id);
}
