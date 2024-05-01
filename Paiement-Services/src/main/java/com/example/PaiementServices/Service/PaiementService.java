package com.example.PaiementServices.Service;

import com.example.PaiementServices.Entity.Paiement;

import java.util.List;

public interface PaiementService {
    List<Paiement> getAllPaiements();
    Paiement SavePaiement(Paiement paiement);
    Paiement getPaiementById(Long id) throws Exception;
}
