package com.example.ProductsServices.Controller;

import com.example.ProductsServices.Entity.DTO.CategoryRequestDto;
import com.example.ProductsServices.Entity.DTO.SousCategoryRequestDto;
import com.example.ProductsServices.Service.CategoryService;
import com.example.ProductsServices.Service.SousCategoryService;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/catalogs/api/v2/souscategories")
public class SousCategoryController {
    @Autowired
    private final SousCategoryService sousCategoryService;

    @GetMapping("/")
    public ResponseEntity<?> getAllSousCategories() {
        try {
            return new ResponseEntity<>(sousCategoryService.getAllSousCategories(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch sous-categories", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSousCategoryById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(sousCategoryService.getSousCategoryById(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch sous-category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSousCategory(@RequestBody SousCategoryRequestDto sousCategoryRequestDto) {
//        try {
//            return new ResponseEntity<>(categoryService.createCategory(categoryRequestDto), HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Failed to create category", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        try{
            return new ResponseEntity<>(sousCategoryService.createSousCategory(sousCategoryRequestDto),HttpStatus.CREATED);
//        }catch (Exception e){
//            return new ResponseEntity<>("Failed to create sous-category", HttpStatus.INTERNAL_SERVER_ERROR);
//        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSousCategory(@PathVariable Long id, @RequestBody SousCategoryRequestDto sousCategoryRequestDto) {
        try {
            return new ResponseEntity<>(sousCategoryService.updateSousCategory(id, sousCategoryRequestDto), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update Sous-Category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSousCategory(@PathVariable Long id) {
        try {
            sousCategoryService.deleteSousCategory(id);
            return ResponseEntity.ok("Sous-Category with ID " + id + " deleted successfully");
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete Sous-Category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
