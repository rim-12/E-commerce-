package com.example.ProductsServices.Service;

import com.example.ProductsServices.Entity.DTO.CategoryRequestDto;
import com.example.ProductsServices.Entity.DTO.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> getAllCategories();
    CategoryResponseDto createCategory(CategoryRequestDto CategoryDto);
    CategoryResponseDto getCategoryById(Long id) throws Exception;
    CategoryResponseDto updateCategory(Long id, CategoryRequestDto CategoryDto) throws Exception;
    void deleteCategory(Long id) throws Exception;
}
