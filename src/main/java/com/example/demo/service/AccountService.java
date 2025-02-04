package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    List<AccountDto> getAllAccounts();  // Ensure this is declared
    AccountDto deposit(Long id, double amount);
    AccountDto withdraw(Long id, double amount);
    AccountDto transfer(Long fromAccountId, Long toAccountId, double amount);
    void deleteAccount(Long id);  // Ensure this is declared
}
