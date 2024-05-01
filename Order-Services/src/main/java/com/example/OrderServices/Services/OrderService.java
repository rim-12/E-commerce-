package com.example.OrderServices.Services;

import com.example.OrderServices.Entities.Dtos.OrderRequest;
import com.example.OrderServices.Entities.Dtos.OrderResponse;

import java.util.List;

public interface OrderService {
    List<OrderResponse> getAllOrders();
    OrderResponse getOrderById(Long orderId);
    OrderResponse createOrder(OrderRequest orderRequest);
    OrderResponse updateOrder(Long orderId, OrderRequest orderRequest);
    void cancelOrderById(Long rentalId);
   // List<OrderResponse> getOrderHistoryByCustomerId(Long customerId);
}
