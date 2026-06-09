package com.example.rest.service;

import com.example.rest.model.Account;

import java.util.List;
import java.util.Map;

public interface AccountService {
    public String createAccount(Account account);
    public Account getAccount(String vendorId);
    public List<Account> getAllAccounts();
    public void updateAccount(Account account);
    String patchAccount( Long accountId, Map<String,Object> updates);
}
