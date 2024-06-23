package com.vipspeciall.bankingapp.repository;

import com.vipspeciall.bankingapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, UUID> {
    List<Account> findByUserId(UUID userId);
    Account findByNumber(String number);
}
