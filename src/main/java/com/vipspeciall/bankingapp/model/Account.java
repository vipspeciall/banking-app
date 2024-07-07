package com.vipspeciall.bankingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    private String number;

    private String name;

    private BigDecimal balance;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    private User user;


}
