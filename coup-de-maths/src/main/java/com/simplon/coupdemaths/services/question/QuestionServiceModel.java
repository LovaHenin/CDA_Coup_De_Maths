package com.simplon.coupdemaths.services.question;

import com.simplon.coupdemaths.dto.DocQuestionDto;
import com.simplon.coupdemaths.enums.LevelEnum;
import com.simplon.coupdemaths.enums.QuestionTypeEnum;
import com.simplon.coupdemaths.services.doc.DocQuestionServiceModel;
import com.simplon.coupdemaths.services.response.ResponseServiceModel;
import com.simplon.coupdemaths.services.student.StudentServiceModel;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class QuestionServiceModel {
    // Unique identifier for the question
    private Long id;

    // Content of the question
    private String question;

    // Level of difficulty for the question (e.g,COLLEGE,HIGH_SCHOOL,UNIVERSITY)
    private String level;

    // Type of the question (e.g., urgent, normal)
    private String questionType;

    // Date and time when the question is created
    private LocalDateTime questionDate;


    // Student who created the question
    private Optional <StudentServiceModel> student;


    private Optional <Long> studentId;


    // List of documents related to the question
   private List<DocQuestionServiceModel> docs;

    // List of responses to the question
    private List<ResponseServiceModel> responses;

    public QuestionServiceModel(String question, String level, LocalDateTime localDateTime, Long aLong, List<DocQuestionDto> docs) {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof QuestionServiceModel;
    }

}
