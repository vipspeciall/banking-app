package com.vipspeciall.bankingapp.model;

import com.vipspeciall.bankingapp.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account from;

    @ManyToOne
    private Account to;

    private BigDecimal amount;

    private LocalDateTime transactionDate;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;


}