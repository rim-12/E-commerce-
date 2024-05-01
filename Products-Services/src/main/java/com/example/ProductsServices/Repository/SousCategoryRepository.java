package com.example.ProductsServices.Repository;

import com.example.ProductsServices.Entity.Category;
import com.example.ProductsServices.Entity.SousCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SousCategoryRepository extends JpaRepository<SousCategory,Long> {
}
