package com.example.rest.repository;

import com.example.rest.model.Account;

import java.util.List;

public interface AccountRepository {

    void save(Account account);
    Account getAccount(Long accountId);
    List<Account> getAllAccounts();
    void updateAccount(Account account);
    void deleteAccount(Long accountId);
}