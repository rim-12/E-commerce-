package com.example.OrderServices.Entities.Dtos;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long orderId;
    private Long customerId;
    private String paymentMethod;
    private String deliveryAddress;
}
