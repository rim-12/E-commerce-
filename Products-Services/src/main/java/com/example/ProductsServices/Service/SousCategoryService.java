package com.example.ProductsServices.Service;

import com.example.ProductsServices.Entity.DTO.CategoryRequestDto;
import com.example.ProductsServices.Entity.DTO.CategoryResponseDto;
import com.example.ProductsServices.Entity.DTO.SousCategoryRequestDto;
import com.example.ProductsServices.Entity.DTO.SousCategoryResponseDto;

import java.util.List;

public interface SousCategoryService {
    List<SousCategoryResponseDto> getAllSousCategories();
    SousCategoryResponseDto createSousCategory(SousCategoryRequestDto SousCategoryDto);
    SousCategoryResponseDto getSousCategoryById(Long id) throws Exception;
    SousCategoryResponseDto updateSousCategory(Long id, SousCategoryRequestDto SousCategoryDto) throws Exception;
    void deleteSousCategory(Long id) throws Exception;
}
