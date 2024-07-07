package com.vipspeciall.bankingapp.controller;

import com.vipspeciall.bankingapp.model.Account;
import com.vipspeciall.bankingapp.model.User;
import com.vipspeciall.bankingapp.service.AccountService;
import com.vipspeciall.bankingapp.service.CustomUserDetailsService;
import com.vipspeciall.bankingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping
    public Account createAccount(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Account account) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findByUsername(userDetails.getUsername());
        return accountService.createAccount(user, account.getName(), account.getNumber(), account.getBalance());
    }

    @GetMapping
    public List<Account> getAccounts(@AuthenticationPrincipal UserDetails userDetails) {
        User user = (User) userDetails;
        return accountService.getAccountsByUser(user.getId());
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}
