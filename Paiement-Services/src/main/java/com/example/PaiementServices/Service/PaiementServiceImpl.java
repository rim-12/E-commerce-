package com.example.PaiementServices.Service;

import com.example.PaiementServices.Entity.Paiement;
import com.example.PaiementServices.Repository.PaiementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PaiementServiceImpl implements PaiementService{
    private final PaiementRepository paiementRepository;
    @Override
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement SavePaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement getPaiementById(Long id) throws Exception {
        return paiementRepository.getById(id);
    }
}
