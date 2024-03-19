package com.example.facebook.service;

import com.example.facebook.model.Account;

import java.util.List;

public interface AccountManagerService {

     Account createAccount(String userName, String email);
     Account getAccount(String email);
     Account updateAccount(Account account);
     void deleteAccount(String email);
}
