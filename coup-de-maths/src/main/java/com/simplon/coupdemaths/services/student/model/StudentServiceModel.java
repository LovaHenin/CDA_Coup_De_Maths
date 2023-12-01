package com.simplon.coupdemaths.services.student.model;

import com.simplon.coupdemaths.services.transaction.TransactionServiceModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;


@Data
@NoArgsConstructor
public class StudentServiceModel {
    // Unique identifier for the student
    private Long id;

    // Name of the student
    private String name;

    // Email address of the student
    private String email;

    // Password associated with the student's account
    private String password;

    // Number of credits available to the student
    private int credits;

    // List of questions posted by the student
    private List<QuestionServiceModel> questions ; // ++++

    // List of transactions associated with the student
    private List<TransactionServiceModel> transactions ;




}
