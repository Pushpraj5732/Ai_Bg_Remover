package com.example.bg.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payment_request")
public class PaymentRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String txnId;

    @Column(unique = true)
    private String referenceCode;

    private String clerkUserId;

    private int amount;

    private boolean verified = false;

    @Column(nullable = false)
    private String status = "PENDING"; // PENDING | APPROVED
}
