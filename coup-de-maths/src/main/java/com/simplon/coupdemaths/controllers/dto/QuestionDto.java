package com.simplon.coupdemaths.controllers.dto;

import com.simplon.coupdemaths.services.model.DocQuestionServiceModel;
import com.simplon.coupdemaths.services.model.ResponseServiceModel;
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
}
