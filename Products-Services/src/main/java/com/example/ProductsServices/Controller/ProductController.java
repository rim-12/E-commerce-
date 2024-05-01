package com.example.ProductsServices.Controller;

import com.example.ProductsServices.Entity.DTO.CategoryRequestDto;
import com.example.ProductsServices.Entity.DTO.ProductRequestDto;
import com.example.ProductsServices.Entity.DTO.ProductResponseDto;
import com.example.ProductsServices.Entity.Product;
import com.example.ProductsServices.Service.CategoryService;
import com.example.ProductsServices.Service.ProductService;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/catalogs/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> getAllProducts() {
        try {
            return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch products", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequestDto productRequestDto) {
//        try {
//            return new ResponseEntity<>(categoryService.createCategory(categoryRequestDto), HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Failed to create category", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        try{
            return new ResponseEntity<>(productService.createProduct(productRequestDto), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Failed to create product", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductRequestDto productRequestDto) {
        try {
            return new ResponseEntity<>(productService.updateProduct(id, productRequestDto), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok("Product with ID " + id + " deleted successfully");
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete Product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/search")
//    public ResponseEntity<ProductResponseDto> getProductByName(@RequestParam String productName) throws Exception {
//        ProductResponseDto productDto = productService.getProductByName(productName);
//        return ResponseEntity.ok(productDto);
//    }
//       @GetMapping("/search/{productName}") // Définir le chemin de l'URL pour inclure le nom du produit
//       public ResponseEntity<?> getProductByName(@PathVariable String productName) throws Exception {
//       try {
//          ProductResponseDto productDto = productService.getProductByName(productName);
//          return ResponseEntity.ok(productDto);
//       } catch (NotFoundException e) {
//          return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//       } catch (Exception e) {
//          return new ResponseEntity<>("Failed to fetch product", HttpStatus.INTERNAL_SERVER_ERROR);
//       }
//       }

    @GetMapping("/search/{productName}")
    public ResponseEntity<?> getProductByName(@PathVariable String productName) {
        try {
            List<ProductResponseDto> productDtos = productService.getProductByName(productName);
            return ResponseEntity.ok(productDtos);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/pagindAndShortingEmployees/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public Page<ProductResponseDto> employeePagination(@PathVariable Integer pageNumber,@PathVariable Integer pageSize){
        return productService.getProductPagination(pageNumber,pageSize);
    }



}
