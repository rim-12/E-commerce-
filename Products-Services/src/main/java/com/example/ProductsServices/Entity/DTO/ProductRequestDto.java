package com.example.ProductsServices.Entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductRequestDto {
    private Long id;
    private Long userId;
    //private Long categorieId;
    private String product_name;
    private String description;
    private String price;
    private byte[] image;
    private Long categoryId;
    private Long souscategoryId;
}
