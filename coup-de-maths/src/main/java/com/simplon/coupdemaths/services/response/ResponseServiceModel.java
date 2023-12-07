package com.simplon.coupdemaths.services.response;


import com.simplon.coupdemaths.services.doc.DocResponseServiceModel;
import com.simplon.coupdemaths.services.professor.ProfessorServiceModel;
import com.simplon.coupdemaths.services.question.QuestionServiceModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
public class ResponseServiceModel {

    private Long id;
    private String response;
    private LocalDateTime responseDate;
    private QuestionServiceModel question;
    private List<DocResponseServiceModel> docs;
    private ProfessorServiceModel professor;
}
