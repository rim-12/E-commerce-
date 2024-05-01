package com.example.OrderServices.Services;

import com.example.OrderServices.Entities.Dtos.OrderItemRequest;
import com.example.OrderServices.Entities.Dtos.OrderItemResponse;

import java.util.List;

public interface OrderItemService {
    List<OrderItemResponse> getAllOrderItems();
    OrderItemResponse createOrderItem(OrderItemRequest orderItemRequest);
    OrderItemResponse getOrderItemById(Long id) throws Exception;
    OrderItemResponse updateOrderItem(Long id, OrderItemRequest orderItemRequest) throws Exception;
    void deleteOrderItem(Long id) throws Exception;
   // double calculateSubTotal(int quantity, double unitPrice);

}
