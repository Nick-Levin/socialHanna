package com.example.facebook.service;

import com.example.facebook.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class AccountManagerServiceImpl implements AccountManagerService {

    private final AccountStorage accountStorage;


    @Override
    public Account createAccount(String userName, String email) {
        Account account = new Account();
        account.setUserName(userName);
        account.setEmail(email);
        account.setPosts(new ArrayList<>());
        accountStorage.getAccounts().add(account);
        return account;
    }

    @Override
    public Account getAccount(String email) {
        return accountStorage.getAccounts().stream()
                .filter(acc -> email.equals(acc.getEmail()))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Account updateAccount(Account account) {
        Account updateAccount = accountStorage.getAccounts().stream()
                .filter(acc -> account.getEmail().equals(acc.getEmail()))
                .findFirst()
                .orElseThrow();
        int index = accountStorage.getAccounts().indexOf(updateAccount);
        accountStorage.getAccounts().remove(index);
        updateAccount.setUserName(account.getUserName());
        accountStorage.getAccounts().add(updateAccount);
        return updateAccount;
    }

    @Override
    public void deleteAccount(String email) {
        Account account = accountStorage.getAccounts().stream()
                .filter(em -> email.equals(em.getEmail()))
                .findFirst()
                .orElseThrow();
        accountStorage.getAccounts().remove(account);
    }
}
