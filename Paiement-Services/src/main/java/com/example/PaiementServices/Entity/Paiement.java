package com.example.PaiementServices.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Entity
@Table(name = "Paiement")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;
    private Long orderId;
    private Long customerId;
    @Column(name = "amount")
    private double amount;
    @Column(name = "paymentDate")
    @CreationTimestamp
    private Date paymentDate;
    @Column(name = "paymentMethod")
    private String paymentMethod;
    @Column(name = "status")
    private String status;
}
