package com.simplon.coupdemaths.controllers.student.dto;

import com.simplon.coupdemaths.services.student.model.DocResponseServiceModel;
import com.simplon.coupdemaths.services.student.model.ProfessorServiceModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ResponseDto {
    private Long id;
    private String response;
    private LocalDateTime responseDate;
    // private QuestionServiceModel question;
    private List<DocResponseServiceModel> docs;
    private ProfessorServiceModel professor;
}
