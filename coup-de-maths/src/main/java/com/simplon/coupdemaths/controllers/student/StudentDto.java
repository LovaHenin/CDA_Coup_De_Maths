package com.simplon.coupdemaths.controllers.student;

import com.simplon.coupdemaths.controllers.question.QuestionDto;
import com.simplon.coupdemaths.controllers.transaction.TransactionDto;

import java.util.List;

public record StudentDto(
        int id,
        String name,
        String email,
        String password,
        int credits,
        List<QuestionDto> questionDtos,
        List<TransactionDto> transactionDtos

) {
}
