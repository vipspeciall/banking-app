package com.vipspeciall.bankingapp.service;

import com.vipspeciall.bankingapp.enums.TransactionStatus;
import com.vipspeciall.bankingapp.model.Account;
import com.vipspeciall.bankingapp.model.Transaction;
import com.vipspeciall.bankingapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Account from, Account to, BigDecimal amount) {
        Transaction transaction = new Transaction();
        transaction.setFrom(from);
        transaction.setTo(to);
        transaction.setAmount(amount);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setStatus(TransactionStatus.SUCCESS);  // Add logic to handle failed transactions
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByAccount(UUID accountId) {
        return transactionRepository.findByFromIdOrToId(accountId, accountId);
    }
}
