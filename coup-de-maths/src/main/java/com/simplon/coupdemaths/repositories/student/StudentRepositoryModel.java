package com.simplon.coupdemaths.repositories.student;

import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.transaction.TransactionRepositoryModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name = "student")
public class StudentRepositoryModel {
    // Unique identifier for the student
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name of the student
    @Column(name = "name")
    private String name;

    // Email address of the student
    @Column(name = "email")
    private String email;

    // Password associated with the student's account
    @Column(name = "password")
    private String password;

    // Number of credits available to the student
    @Column(name = "credits")
    private int credits;

    // List of questions posted by the student
    @OneToMany(mappedBy = "student", orphanRemoval = true)
    private List<QuestionRepositoryModel> questions;

    // List of transactions associated with the student
    @OneToMany(mappedBy = "student", orphanRemoval = true)
    private List<TransactionRepositoryModel> transactions;


    @Override
    public String toString() {
        return "StudentRepositoryModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", credits=" + credits +
                ", questions=" + questions +
                ", transactions=" + transactions +
                '}';
    }
}
