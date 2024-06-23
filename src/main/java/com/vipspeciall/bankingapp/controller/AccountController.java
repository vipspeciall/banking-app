package com.vipspeciall.bankingapp.controller;

import com.vipspeciall.bankingapp.model.Account;
import com.vipspeciall.bankingapp.model.User;
import com.vipspeciall.bankingapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Account account) {
        User user = (User) userDetails; // Assuming userDetails is of type User
        return accountService.createAccount(user, account.getName(), account.getNumber(), account.getBalance());
    }

    @GetMapping
    public List<Account> getAccounts(@AuthenticationPrincipal UserDetails userDetails) {
        User user = (User) userDetails;
        return accountService.getAccountsByUser(user.getId());
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable UUID id) {
        return accountService.getAccountById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable UUID id) {
        accountService.deleteAccount(id);
    }
}
