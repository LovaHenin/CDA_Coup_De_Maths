package com.simplon.coupdemaths.services.student.model;

import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class QuestionServiceModel {
    private Long id;
    private String question;
    private String level;
    private String questionType;
    private LocalDateTime questionDate;
    private Long studentId;  //--
    private StudentServiceModel student; // bouchonné de repo -> service
    private List<DocQuestionServiceModel> docs;
    private List<ResponseServiceModel> responses;
}
