package com.example.OrderServices.Services.ServicesImpl;

import com.example.OrderServices.Entities.Dtos.OrderItemRequest;
import com.example.OrderServices.Entities.Dtos.OrderItemResponse;
import com.example.OrderServices.Entities.Order;
import com.example.OrderServices.Entities.OrderItems;
import com.example.OrderServices.Mapper.MappingProfile;
import com.example.OrderServices.Repositories.OrderItemRepository;
import com.example.OrderServices.Repositories.OrderRepository;
import com.example.OrderServices.Services.OrderItemService;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    final private OrderItemRepository orderItemRepository;
    @Autowired
    final private OrderRepository orderRepository;
    @Override
    public List<OrderItemResponse> getAllOrderItems() {
        return orderItemRepository.findAll().stream()
                .map(MappingProfile::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemResponse createOrderItem(OrderItemRequest orderItemRequest) {
        OrderItems orderItems = MappingProfile.mapToEntity(orderItemRequest);
        Order order = orderRepository.getById(orderItemRequest.getOrderId());
        // Récupérer la sous-catégorie par son identifiant


        // Vérifier si la sous-catégorie existe
        if (order == null) {
            // Gérer l'erreur ici, par exemple :
            throw new IllegalArgumentException("Order not Exist");
        }
        orderItems.setOrder(order);

        // Enregistrer le produit avec la sous-catégorie associée
        OrderItems savedOrder = orderItemRepository.save(orderItems);

        // Mapper et retourner la réponse DTO du produit sauvegardé
        return MappingProfile.mapToDto(savedOrder);
    }

    @Override
    public OrderItemResponse getOrderItemById(Long id) throws Exception {
        var OrderItem = orderItemRepository.findById(id).orElseThrow(() -> new NotFoundException("orderItem not found"));
        return MappingProfile.mapToDto(OrderItem);
    }

    @Override
    public OrderItemResponse updateOrderItem(Long id, OrderItemRequest orderItemRequest) throws Exception {
        var orderItem = orderItemRepository.findById(id).orElseThrow(() -> new NotFoundException("OrderItem not found"));
        orderItem.setQuantity(orderItemRequest.getQuantity());
        orderItem.setProductId(orderItemRequest.getProductId());
        orderItem.setUnitPrice(orderItemRequest.getUnitPrice());
        return MappingProfile.mapToDto(orderItemRepository.save(orderItem));
    }

    @Override
    public void deleteOrderItem(Long id) throws Exception {
        var orderItem = orderItemRepository.findById(id).orElseThrow(() -> new NotFoundException("OrderItem not found"));
        orderItemRepository.delete(orderItem);
    }
}
