package com.simplon.coupdemaths.services.response;

import com.simplon.coupdemaths.repositories.doc.DocResponseRepositoryModel;
import com.simplon.coupdemaths.services.professor.ProfessorServiceModel;
import com.simplon.coupdemaths.services.question.QuestionServiceModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Service
@NoArgsConstructor
public class ResponseServiceModel {

    private int id;
    private String response;
    private LocalDateTime responseDate;
    private QuestionServiceModel question;
    private List<DocResponseRepositoryModel> docs;
    private ProfessorServiceModel professor;
}
