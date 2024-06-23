package com.vipspeciall.bankingapp.repository;

import com.vipspeciall.bankingapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByFromIdOrToId(UUID accountIdFrom, UUID accountIdTo);
}
