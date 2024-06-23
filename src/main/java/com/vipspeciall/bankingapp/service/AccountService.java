package com.vipspeciall.bankingapp.service;

import com.vipspeciall.bankingapp.model.Account;
import com.vipspeciall.bankingapp.model.User;
import com.vipspeciall.bankingapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(User user, String name, String number, BigDecimal balance) {
        Account account = new Account();
        account.setUser(user);
        account.setName(name);
        account.setNumber(number);
        account.setBalance(balance);
        account.setCreatedAt(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());
        return accountRepository.save(account);
    }

    public List<Account> getAccountsByUser(UUID userId) {
        return accountRepository.findByUserId(userId);
    }

    public Account getAccountById(UUID accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    public void deleteAccount(UUID accountId) {
        accountRepository.deleteById(accountId);
    }
}
