package com.example.OrderServices.Services.ServicesImpl;

import com.example.OrderServices.Entities.Dtos.OrderRequest;
import com.example.OrderServices.Entities.Dtos.OrderResponse;
import com.example.OrderServices.Entities.Order;
import com.example.OrderServices.Entities.OrderItems;
import com.example.OrderServices.Mapper.MappingProfile;
import com.example.OrderServices.Repositories.OrderItemRepository;
import com.example.OrderServices.Repositories.OrderRepository;
import com.example.OrderServices.Services.OrderService;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Autowired
    final private OrderRepository orderRepository;
    final private OrderItemRepository orderItemRepository;
    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(MappingProfile::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse getOrderById(Long orderId) {
        var order = orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException("order not found"));
        return MappingProfile.mapToDto(order);
    }

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        var order = MappingProfile.mapToEntity(orderRequest);
        return MappingProfile.mapToDto(orderRepository.save(order));
    }

    @Override
    public OrderResponse updateOrder(Long orderId, OrderRequest orderRequest) {
        var order = orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException("order not found"));
        order.setCustomerId(orderRequest.getCustomerId());
        order.setPaymentMethod(orderRequest.getPaymentMethod());
        order.setDeliveryAddress(orderRequest.getDeliveryAddress());
        return MappingProfile.mapToDto(orderRepository.save(order));
    }

    @Override
    public void cancelOrderById(Long rentalId) {
        var order = orderRepository.findById(rentalId).orElseThrow(() -> new NotFoundException("Order not found"));
        List<OrderItems> orderItems = order.getOrderItems();
        if (orderItems != null) {
            for (OrderItems orderItems1 : orderItems) {
                orderItemRepository.delete(orderItems1);
            }
        }

        orderRepository.delete(order);
    }

//    @Override
//    public List<OrderResponse> getOrderHistoryByCustomerId(Long customerId) {
//        return null;
//    }
}
