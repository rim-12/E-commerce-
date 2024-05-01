package com.example.OrderServices.Repositories;

import com.example.OrderServices.Entities.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItems,Long> {
}
