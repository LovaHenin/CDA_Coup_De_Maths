package com.simplon.coupdemaths.services.student;

import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.transaction.TransactionRepositoryModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Data
@Service
@NoArgsConstructor
public class StudentServiceModel {
    // Unique identifier for the student
    private int id;

    // Name of the student
    private String name;

    // Email address of the student
    private String email;

    // Password associated with the student's account
    private String password;

    // Number of credits available to the student
    private int credits;

    // List of questions posted by the student
    private List<QuestionRepositoryModel> questions ;

    // List of transactions associated with the student
    private List<TransactionRepositoryModel> transactions ;
}
