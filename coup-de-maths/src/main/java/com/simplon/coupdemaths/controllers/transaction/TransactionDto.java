package com.simplon.coupdemaths.controllers.transaction;

import com.simplon.coupdemaths.enums.TransactionTypeEnum;

import java.time.LocalDateTime;

public record TransactionDto(
        int id,
        LocalDateTime transactionDate,
        TransactionTypeEnum transactionType,
        float amount
) {
}
