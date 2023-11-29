package com.simplon.coupdemaths.services.doc;

import com.simplon.coupdemaths.services.question.QuestionServiceModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

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
    private QuestionServiceModel question;
}
