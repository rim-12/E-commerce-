package com.example.ProductsServices.Repository;

import com.example.ProductsServices.Entity.DTO.ProductResponseDto;
import com.example.ProductsServices.Entity.Product;
import feign.Param;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT p FROM Product p WHERE p.product_name LIKE %:productName%")
    List<Product> findByProductName(@Param("productName") String productName);

    @Query("SELECT p FROM Product p WHERE p.product_name LIKE %:productName%")
    Page<Product> findByProductName(@Param("productName") String productName, Pageable pageable);

}
