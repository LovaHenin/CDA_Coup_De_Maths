package com.simplon.coupdemaths.dto;

import java.time.LocalDateTime;

public record TransactionDto(
        Long id,
        LocalDateTime transactionDate,
        String transactionType,
        float amount
) {
}
