package com.example.ProductsServices.Service;

import com.example.ProductsServices.Entity.Category;
import com.example.ProductsServices.Entity.DTO.CategoryRequestDto;
import com.example.ProductsServices.Entity.DTO.CategoryResponseDto;
import com.example.ProductsServices.Entity.DTO.SousCategoryRequestDto;
import com.example.ProductsServices.Entity.DTO.SousCategoryResponseDto;
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
public class SousCategoryServiceImp implements SousCategoryService {

    private final SousCategoryRepository sousCategoryRepository;
    private final CategoryRepository CategoryRepository;
    private final ProductRepository productRepository;
    @Override
    public List<SousCategoryResponseDto> getAllSousCategories() {
        return sousCategoryRepository.findAll().stream()
                .map(MappingProfile::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SousCategoryResponseDto createSousCategory(SousCategoryRequestDto SousCategoryDto) {
        SousCategory sousCategory = MappingProfile.mapToEntity(SousCategoryDto);
        Category category=CategoryRepository.getById(SousCategoryDto.getCategoryId());
        sousCategory.setCategory(category);
        return MappingProfile.mapToDto(sousCategoryRepository.save(sousCategory));
    }

    @Override
    public SousCategoryResponseDto getSousCategoryById(Long id) throws Exception {
        var sousCategory = sousCategoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Sous-Category not found"));
        return MappingProfile.mapToDto(sousCategory);    }

    @Override
    public SousCategoryResponseDto updateSousCategory(Long id, SousCategoryRequestDto SousCategoryDto) throws Exception {
//        var sousCategory = sousCategoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Sous-Category not found"));
//        sousCategory.setName(SousCategoryDto.getName());
//        Category category=CategoryRepository.getById(SousCategoryDto.getCategoryId());
//        sousCategory.setCategory(category);
//        return MappingProfile.mapToDto(sousCategoryRepository.save(sousCategory));
        var sousCategory = sousCategoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Sous-Category not found"));
        sousCategory.setName(SousCategoryDto.getName());

        if (!sousCategory.getCategory().getId().equals(SousCategoryDto.getCategoryId())) {
            Category category = CategoryRepository.getById(SousCategoryDto.getCategoryId());
            sousCategory.setCategory(category);
        }

        return MappingProfile.mapToDto(sousCategoryRepository.save(sousCategory));
    }

    @Override
    public void deleteSousCategory(Long id) throws Exception {
        var souscategory = sousCategoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Sous-Category not found"));
        List<Product> products = souscategory.getProducts();
        if (products != null) {
            for (Product product : products) {
                productRepository.delete(product);
            }
        }
        sousCategoryRepository.delete(souscategory);
    }
}
