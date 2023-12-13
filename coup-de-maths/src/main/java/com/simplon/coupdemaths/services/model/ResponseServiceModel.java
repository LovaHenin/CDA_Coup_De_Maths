package com.simplon.coupdemaths.services.model;


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
    private Long questionId;
    private QuestionServiceModel question;  // bouchonné de repo -> service dans le mapper du ResponseServiceModel
    private Long professorId;
    private ProfessorServiceModel professor;// idem bouchonné
    private List<DocResponseServiceModel> docs;

}
