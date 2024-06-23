package com.vipspeciall.bankingapp.controller;

import com.vipspeciall.bankingapp.model.Account;
import com.vipspeciall.bankingapp.model.Transaction;
import com.vipspeciall.bankingapp.service.AccountService;
import com.vipspeciall.bankingapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @PostMapping("/transfer")
    public Transaction transfer(@RequestParam UUID fromAccountId, @RequestParam UUID toAccountId,
                                @RequestParam BigDecimal amount) {
        Account from = accountService.getAccountById(fromAccountId);
        Account to = accountService.getAccountById(toAccountId);
        return transactionService.createTransaction(from, to, amount);
    }

    @GetMapping("/account/{accountId}")
    public List<Transaction> getTransactions(@PathVariable UUID accountId) {
        return transactionService.getTransactionsByAccount(accountId);
    }
}
