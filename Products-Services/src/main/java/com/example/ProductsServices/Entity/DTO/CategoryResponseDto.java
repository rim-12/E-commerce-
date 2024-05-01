package com.example.ProductsServices.Entity.DTO;

import com.example.ProductsServices.Entity.Category;
import com.example.ProductsServices.Entity.SousCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryResponseDto {
    private Long id;
    private String name;
    private List<ProductResponseDto> productList;
    //@JsonManagedReference
    private List<SousCategoryResponseDto> sousCategoryList;

}
