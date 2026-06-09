package com.example.rest.service;

import com.example.rest.exception.AccountNotFoundException;
import com.example.rest.model.Account;
import com.example.rest.repository.AccountRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {
    AccountRepositoryImpl repository;

    public AccountServiceImpl(AccountRepositoryImpl repository){
        this.repository=repository;
    }

    public String createAccount(
            Account account) {

        repository.save(account);

        return "Account Created Successfully";
    }

    public Account getAccount(
            String accountId) {

        if(repository.getAccount(Long.valueOf(accountId))==null)
            throw new AccountNotFoundException("Requested account Does Not Exist");
        return repository.getAccount(Long.valueOf(accountId));
    }

    public List<Account> getAllAccounts() {

        return repository.getAllAccounts();
    }

    public String deleteAccount(
            String accountId) {

        repository.deleteAccount(Long.valueOf(accountId));

        return "Account Deleted Successfully";
    }

    public void updateAccount(Account account){
        repository.updateAccount(account);
    }

   public String patchAccount( Long accountId, Map<String,Object> updates){
        return repository.patchAccount(accountId,updates);
   }
}

