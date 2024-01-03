package com.simplon.coupdemaths.controllers.dto;

import com.simplon.coupdemaths.services.model.DocQuestionServiceModel;
import com.simplon.coupdemaths.services.model.ResponseServiceModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class QuestionDto {
    private Long id;
    private String question;
    private String level;
    private String questionType;
    private LocalDateTime questionDate;
    private Long studentId; //--
    private StudentDto student;
    private List<DocQuestionServiceModel> docs;
    private List<ResponseServiceModel> responses;

    public QuestionDto(String question, String level, String questionType, Long studentId) {
        this.question = question;
        this.level = level;
        this.questionType = questionType;
        this.studentId = studentId;
    }

    public QuestionDto(String question, String level, String questionType) {
        this.question = question;
        this.level = level;
        this.questionType = questionType;
    }

}
