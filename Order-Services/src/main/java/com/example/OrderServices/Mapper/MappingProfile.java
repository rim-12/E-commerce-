package com.example.OrderServices.Mapper;

import com.example.OrderServices.Entities.Dtos.OrderItemRequest;
import com.example.OrderServices.Entities.Dtos.OrderItemResponse;
import com.example.OrderServices.Entities.Dtos.OrderRequest;
import com.example.OrderServices.Entities.Dtos.OrderResponse;
import com.example.OrderServices.Entities.Order;
import com.example.OrderServices.Entities.OrderItems;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MappingProfile {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static Order mapToEntity(OrderRequest orderRequest) {
        return modelMapper.map(orderRequest, Order.class);
    }
    public static OrderResponse mapToDto(Order order) {
        //return modelMapper.map(category, CategoryResponseDto.class);
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(order.getOrderId());
        orderResponse.setCustomerId(order.getCustomerId());
        orderResponse.setTotalAmount(order.getTotalAmount());
        orderResponse.setPaymentMethod(order.getPaymentMethod());
        orderResponse.setOrderDate(order.getOrderDate());
        orderResponse.setDeliveryAddress(order.getDeliveryAddress());
        orderResponse.setStatus(order.getStatus());

        // Mapper la liste de produits
        if (order.getOrderItems() != null) {
            ArrayList<OrderItemResponse> orderItemResponses = new ArrayList<>(); // Spécifier explicitement le type
            for (OrderItems orderItems : order.getOrderItems()) {
                orderItemResponses.add(mapToDto(orderItems));
            }

            orderResponse.setOrderItems(orderItemResponses);
        }

        // Mapper la liste de sous-catégories
        // Assurez-vous que le même traitement est fait pour les sous-catégories si nécessaire

        return orderResponse;
    }
    public static OrderItems mapToEntity(OrderItemRequest orderItemRequest) {
        return modelMapper.map(orderItemRequest, OrderItems.class);
    }
    public static OrderItemResponse mapToDtos(OrderItems orderItems){
        return modelMapper.map(orderItems, OrderItemResponse.class);
    }
    public static OrderItemResponse mapToDto(OrderItems orderItems) {
//        return modelMapper.map(product, ProductResponseDto.class);
        OrderItemResponse orderItemResponse = new OrderItemResponse();
        orderItemResponse.setItemId(orderItems.getItemId());
        orderItemResponse.setProductId(orderItems.getProductId());
        orderItemResponse.setOrderId(orderItems.getOrder().getOrderId());
        orderItemResponse.setQuantity(orderItems.getQuantity());
        orderItemResponse.setUnitPrice(orderItems.getUnitPrice());

        // Mapper les autres attributs de ProductResponseDto si nécessaire
        return orderItemResponse;
    }

    private static class List<T> {
    }
}
