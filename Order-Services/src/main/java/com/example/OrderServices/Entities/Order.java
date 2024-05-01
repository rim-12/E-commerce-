package com.example.OrderServices.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Data
@Getter
@Setter
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "totalAmount")
    private double totalAmount;

    @Column(name = "paymentMethod")
    private String paymentMethod;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date orderDate;

    @Column(name = "deliveryAddress")
    private String deliveryAddress;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "order"/*, cascade = CascadeType.ALL, fetch = FetchType.LAZY*/)
    private List<OrderItems> orderItems= new ArrayList<>();
}
