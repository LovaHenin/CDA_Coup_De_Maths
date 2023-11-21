package com.simplon.coupdemaths.repositories.student;

import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.transaction.TransactionRepositoryModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "student")
public class StudentRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "credits")
    private int credits;

    @OneToMany(mappedBy = "student", orphanRemoval = true)
    private List<QuestionRepositoryModel> questions = new ArrayList<>();

    @OneToMany(mappedBy = "student", orphanRemoval = true)
    private List<TransactionRepositoryModel> transactions = new ArrayList<>();

}
