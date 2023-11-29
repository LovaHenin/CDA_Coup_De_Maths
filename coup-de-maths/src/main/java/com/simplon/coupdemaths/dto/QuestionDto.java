package com.simplon.coupdemaths.dto;

import com.simplon.coupdemaths.enums.LevelEnum;
import com.simplon.coupdemaths.enums.QuestionTypeEnum;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;

import java.time.LocalDateTime;
import java.util.List;

public record QuestionDto(
        Long id,
        String question,
       String level,
        String questionType,
        LocalDateTime questionDate,
        Long studentId,
        List<DocQuestionDto> docs
) {
}
