package com.simplon.coupdemaths.controllers.student.dto;

import com.simplon.coupdemaths.dto.DocQuestionDto;
import com.simplon.coupdemaths.dto.ResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public record QuestionDto(
        Long id,
        String question,
        String level,
        String questionType,
        LocalDateTime questionDate,
        Long studentId,
        List<DocQuestionDto> docs,
        List<ResponseDto> responses
) {
}
