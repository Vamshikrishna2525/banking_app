package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private Long id;

    @NotNull(message = "Account holder name is required")
    @Size(min = 3, max = 100, message = "Account holder name should be between 3 and 100 characters")
    private String accountHolderName;

    @NotNull(message = "Balance is required")
    @Min(value = 0, message = "Balance must be a positive number")
    private double balance;
}
