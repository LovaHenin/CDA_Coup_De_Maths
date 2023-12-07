package com.simplon.coupdemaths.services.doc;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocQuestionServiceModel {
    // Unique identifier for the document
    private Long id;

    // Name of the document
    private String documentName;

    // Path to the document
    private String documentPath;

    // Question to which the document is related
    // private QuestionServiceModel question;
}
