package com.example.PaiementServices.Controller;

import com.example.PaiementServices.Entity.Paiement;
import com.example.PaiementServices.Service.PaiementService;
import com.example.PaiementServices.Service.PaiementServiceImpl;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/paiement/api/v1/paiement")
public class PaiementController {
    private final PaiementService paiementService;

    @GetMapping("/")
    public ResponseEntity<?> getAllPaiements() {
        try {
            return new ResponseEntity<>(paiementService.getAllPaiements(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch paiements", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<?> savePaiement(@RequestBody Paiement paiement) {

        try{
            return new ResponseEntity<>(paiementService.SavePaiement(paiement), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Failed to save paiement", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPaiementById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(paiementService.getPaiementById(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch paiement", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
