package com.example.ProductsServices.Repository;

import com.example.ProductsServices.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
