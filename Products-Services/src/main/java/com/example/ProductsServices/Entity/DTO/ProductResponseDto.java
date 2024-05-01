package com.example.ProductsServices.Entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductResponseDto {
    private Long id;

    private String product_name;

    private String description;

    private String price;

    private byte[] image;

    private Long categoryId;

    private Long souscategoryId;
}
