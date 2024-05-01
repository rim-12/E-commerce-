package com.example.ProductsServices.Entity.DTO;

import com.example.ProductsServices.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SousCategoryRequestDto {
    private Long id;
    private String name;
    private Long categoryId;
}


