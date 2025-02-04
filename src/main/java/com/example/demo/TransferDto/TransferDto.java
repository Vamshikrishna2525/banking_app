package com.example.demo.TransferDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDto {

    private Long fromAccountId;
    private Long toAccountId;
    private double amount;
}
