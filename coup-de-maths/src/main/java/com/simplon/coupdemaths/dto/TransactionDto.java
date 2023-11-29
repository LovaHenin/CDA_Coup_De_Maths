package com.simplon.coupdemaths.dto;

import com.simplon.coupdemaths.enums.TransactionTypeEnum;

import java.time.LocalDateTime;

public record TransactionDto(
        Long id,
        LocalDateTime transactionDate,
       String transactionType,
        float amount
) {
}
