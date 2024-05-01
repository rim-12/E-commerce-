package com.example.ProductsServices.Utilis;

import com.example.ProductsServices.Entity.Category;
import com.example.ProductsServices.Entity.DTO.*;
import com.example.ProductsServices.Entity.Product;
import com.example.ProductsServices.Entity.SousCategory;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;

public class MappingProfile {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static Category mapToEntity(CategoryRequestDto categoryRequestDto) {
        return modelMapper.map(categoryRequestDto, Category.class);
    }
    public static CategoryResponseDto mapToDto(Category category) {
        //return modelMapper.map(category, CategoryResponseDto.class);
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setId(category.getId());
        dto.setName(category.getName());

        // Mapper la liste de produits
        if (category.getProducts() != null) {
            ArrayList<ProductResponseDto> productDtoList = new ArrayList<>(); // Spécifier explicitement le type
            for (Product product : category.getProducts()) {
                productDtoList.add(mapToDto(product));
            }
            dto.setProductList(productDtoList);
        }

        if (category.getSousCategories() != null) {
            ArrayList<SousCategoryResponseDto> sousCategoryDtoList = new ArrayList<>();
            for (SousCategory sousCategory : category.getSousCategories()) {
                sousCategoryDtoList.add(mapToDto(sousCategory));
            }
            dto.setSousCategoryList(sousCategoryDtoList);
        }


        // Mapper la liste de sous-catégories
        // Assurez-vous que le même traitement est fait pour les sous-catégories si nécessaire

        return dto;
    }
    public static Product mapToEntity(ProductRequestDto productRequestDto) {
        return modelMapper.map(productRequestDto, Product.class);
    }
    public static ProductResponseDto mapToDtos(Product product){
        return modelMapper.map(product, ProductResponseDto.class);
    }
    public static ProductResponseDto mapToDto(Product product) {
//        return modelMapper.map(product, ProductResponseDto.class);
        ProductResponseDto productDto = new ProductResponseDto();
        productDto.setId(product.getId());
        productDto.setProduct_name(product.getProduct_name());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImage(product.getImage());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setSouscategoryId(product.getSousCategory().getId());

        // Mapper les autres attributs de ProductResponseDto si nécessaire
        return productDto;
    }

    public static SousCategory mapToEntity(SousCategoryRequestDto sousCategoryRequestDto) {
        return modelMapper.map(sousCategoryRequestDto, SousCategory.class);
    }

    public static SousCategoryResponseDto mapToDto(SousCategory sousCategory) {
//        return modelMapper.map(sousCategory, SousCategoryResponseDto.class);
        SousCategoryResponseDto sousCategoryDto = new SousCategoryResponseDto();
        sousCategoryDto.setId(sousCategory.getId());
        sousCategoryDto.setName(sousCategory.getName());
        sousCategoryDto.setCategoryId(sousCategory.getCategory().getId()); // Assurez-vous que la méthode getCategory() est correctement définie dans SousCategory

        // Mapper la liste d'identifiants de produits
        // Mapper la liste de ProductResponseDto
        if (sousCategory.getProducts() != null) {
            ArrayList<ProductResponseDto> productResponseDtoList = new ArrayList<>();
            for (Product product : sousCategory.getProducts()) {
                ProductResponseDto productResponseDto = mapToDto(product);
                productResponseDtoList.add(productResponseDto);
            }
            sousCategoryDto.setProductDTOList(productResponseDtoList);
        }

        return sousCategoryDto;
    }

    private static class List<T> {
    }
}
