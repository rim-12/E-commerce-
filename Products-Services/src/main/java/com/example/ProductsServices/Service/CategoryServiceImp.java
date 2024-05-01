package com.example.ProductsServices.Service;

import com.example.ProductsServices.Entity.Category;
import com.example.ProductsServices.Entity.DTO.CategoryRequestDto;
import com.example.ProductsServices.Entity.DTO.CategoryResponseDto;
import com.example.ProductsServices.Entity.Product;
import com.example.ProductsServices.Entity.SousCategory;
import com.example.ProductsServices.Repository.CategoryRepository;
import com.example.ProductsServices.Repository.ProductRepository;
import com.example.ProductsServices.Repository.SousCategoryRepository;
import com.example.ProductsServices.Utilis.MappingProfile;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImp implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final SousCategoryRepository sousCategoryRepository;
    private final ProductRepository productRepository;
    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(MappingProfile::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto CategoryDto) {
//        var category = MappingProfile.mapToEntity(CategoryDto);
//        return MappingProfile.mapToDto(categoryRepository.save(category));
        var category = MappingProfile.mapToEntity(CategoryDto);
        return MappingProfile.mapToDto(categoryRepository.save(category));
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) throws Exception {
        var category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("category not found"));
        return MappingProfile.mapToDto(category);
    }

    @Override
    public CategoryResponseDto updateCategory(Long id, CategoryRequestDto CategoryDto) throws Exception {
        var category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found"));
        category.setName(CategoryDto.getName());
        return MappingProfile.mapToDto(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(Long id) throws Exception {
        var category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found"));
        List<Product> products = category.getProducts();
        List<SousCategory> sousCategories = category.getSousCategories();
        if (products != null) {
            for (Product product : products) {
                productRepository.delete(product);
            }
        }
        if (sousCategories != null) {
            for (SousCategory sousCategory : sousCategories) {
                sousCategoryRepository.delete(sousCategory);
            }
        }
        categoryRepository.delete(category);
    }
}
