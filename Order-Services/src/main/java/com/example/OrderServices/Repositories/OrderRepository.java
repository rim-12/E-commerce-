package com.example.OrderServices.Repositories;

import com.example.OrderServices.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
