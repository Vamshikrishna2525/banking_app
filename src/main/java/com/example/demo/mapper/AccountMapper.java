package com.example.demo.mapper;

import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;

public class AccountMapper {

    // Map AccountDto to Account entity
    public static Account mapToAccount(AccountDto accountDto) {
        return new Account(
            accountDto.getId(),
            accountDto.getAccountHolderName(),
            accountDto.getBalance()
        );
    }

    // Map Account entity to AccountDto
    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(
            account.getId(),
            account.getAccountHolderName(),
            account.getBalance()
        );
    }
}
