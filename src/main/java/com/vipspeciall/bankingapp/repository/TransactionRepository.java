package com.vipspeciall.bankingapp.repository;

import com.vipspeciall.bankingapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByFromIdOrToId(Long accountIdFrom, Long accountIdTo);
}
