package com.simplon.coupdemaths.dto;

import java.util.List;

public record StudentDto(
        Long id,
        String name,
        String email,
        String password,
        int credits,
        List<QuestionDto> questions,
        List<TransactionDto> transactions

) {
}
