package com.vipspeciall.bankingapp.repository;

import com.vipspeciall.bankingapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUserId(Long userId);
    Account findByNumber(String number);
}
