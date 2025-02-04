package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.TransferDto.TransferDto;
import com.example.demo.dto.AccountDto;
import com.example.demo.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@Validated
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Add Account REST API
    @PostMapping("/add")
    public ResponseEntity<AccountDto> addAccount(@Validated @RequestBody AccountDto accountDto) {
        AccountDto createdAccount = accountService.createAccount(accountDto);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    // Get Account by ID REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

 
 // Get All Accounts REST API
    @GetMapping("/all")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    // Deposit money into account
    @PostMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody double amount) {
        AccountDto updatedAccount = accountService.deposit(id, amount);
        return ResponseEntity.ok(updatedAccount);
    }

    // Withdraw money from account
    @PostMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody double amount) {
        AccountDto updatedAccount = accountService.withdraw(id, amount);
        return ResponseEntity.ok(updatedAccount);
    }

    // Transfer money from one account to another
    @PostMapping("/transfer")
    public ResponseEntity<AccountDto> transfer(@RequestBody TransferDto transferDto) {
        AccountDto updatedAccount = accountService.transfer(transferDto.getFromAccountId(), transferDto.getToAccountId(), transferDto.getAmount());
        return ResponseEntity.ok(updatedAccount);
    }

 // Delete Account REST API
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();  // HTTP 204 No Content
    }
}
