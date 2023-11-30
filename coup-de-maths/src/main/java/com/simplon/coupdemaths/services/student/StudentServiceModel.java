package com.simplon.coupdemaths.services.student;

import com.simplon.coupdemaths.services.question.QuestionServiceModel;
import com.simplon.coupdemaths.services.transaction.TransactionServiceModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
    private Optional<List<QuestionServiceModel>> questions ; // ++++

    // List of transactions associated with the student
    private Optional<List<TransactionServiceModel>> transactions ;

    public StudentServiceModel(Long id, String name, String email, String password, int credits, Optional<List<QuestionServiceModel>> questions, Optional<List<TransactionServiceModel>> transactions) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.credits = credits;
        this.questions = questions;
        this.transactions = transactions;
    }


}
