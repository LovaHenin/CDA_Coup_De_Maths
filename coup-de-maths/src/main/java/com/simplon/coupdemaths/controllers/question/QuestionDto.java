package com.simplon.coupdemaths.controllers.question;

import com.simplon.coupdemaths.controllers.doc.DocQuestionDto;
import com.simplon.coupdemaths.controllers.response.ResponseDto;
import com.simplon.coupdemaths.enums.LevelEnum;
import com.simplon.coupdemaths.enums.QuestionTypeEnum;

import java.time.LocalDateTime;
import java.util.List;

public record QuestionDto(
        int id,
        String question,
        LevelEnum level,
        QuestionTypeEnum questionType,
        LocalDateTime questionDate,

        List<DocQuestionDto> docs,
        List<ResponseDto> responses
) {
}
