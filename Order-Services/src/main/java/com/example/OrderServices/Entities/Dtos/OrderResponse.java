package com.example.OrderServices.Entities.Dtos;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long orderId;
    private Long customerId;
    private double totalAmount;
    private String paymentMethod;
    private Date orderDate;
    private String deliveryAddress;
    private String status;
    List<OrderItemResponse> orderItems=new ArrayList<>();
}
