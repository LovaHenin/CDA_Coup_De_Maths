package com.simplon.coupdemaths.controllers.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocQuestionDto {
    private Long id;
    private String documentName;
    private String documentPath;
    //private QuestionDto question;
}
