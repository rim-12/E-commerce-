package com.example.OrderServices.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Table(name = "OrderItems")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    @Column(name = "productId")
    private Long productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unitPrice")
    private double unitPrice;

    @Column(name = "subTotal")
    private double subTotal; // Ajout du champ subTotal

    @ManyToOne
    private Order order;


}
