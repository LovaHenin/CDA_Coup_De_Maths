package com.simplon.coupdemaths.services.student.model;

import com.simplon.coupdemaths.services.response.ResponseServiceModel;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
    private StudentServiceModel student;


    private Long studentId;


    // List of documents related to the question
   private List<DocQuestionServiceModel> docs;

    // List of responses to the question
    private List<ResponseServiceModel> responses;


}
