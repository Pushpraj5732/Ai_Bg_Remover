package com.example.bg.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_credit")
public class UserCredit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String clerkUserId;

    private int credits;
}
