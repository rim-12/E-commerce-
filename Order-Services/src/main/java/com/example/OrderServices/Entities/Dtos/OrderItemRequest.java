package com.example.OrderServices.Entities.Dtos;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest {
    private Long itemId;
    private Long productId;
    private Long orderId;
    private int quantity;
    private double unitPrice;
}
