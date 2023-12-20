package com.simplon.coupdemaths.services.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocQuestionServiceModel {
    private Long id;
    private String documentName;
    private String documentPath;
    //private QuestionRepositoryModel question;
}
