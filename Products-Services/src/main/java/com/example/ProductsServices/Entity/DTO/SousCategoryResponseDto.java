package com.example.ProductsServices.Entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SousCategoryResponseDto {
    private Long id;
    private String name;
    private List<ProductResponseDto> productDTOList;
    //@JsonBackReference
    private Long categoryId;
}
