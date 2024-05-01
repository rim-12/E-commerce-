package com.example.PaiementServices.Repository;

import com.example.PaiementServices.Entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement,Long> {
}
