package com.example.OrderServices.Entities.Dtos;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponse {
    private Long itemId;
    private Long productId;
    private Long orderId;
    private int quantity;
    private double unitPrice;
    private double subTotal; // Ajout du champ subTotal
}
