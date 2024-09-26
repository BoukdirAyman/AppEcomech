package org.example.appecomtech.dao.repository;

import org.example.appecomtech.dao.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
