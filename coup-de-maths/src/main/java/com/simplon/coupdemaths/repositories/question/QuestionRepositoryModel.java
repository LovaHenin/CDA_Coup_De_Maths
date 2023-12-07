package com.simplon.coupdemaths.repositories.question;

import com.simplon.coupdemaths.enums.LevelEnum;
import com.simplon.coupdemaths.enums.QuestionTypeEnum;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.response.ResponseRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "question")
@ToString
public class QuestionRepositoryModel {

    // Primary key for the Question entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Content of the question
    @Column(name = "question")
    private String question;

    // Level of difficulty for the question (e.g,COLLEGE,HIGH_SCHOOL,UNIVERSITY)
    @Column(name = "level")
    private String level;

    // Type of the question (e.g., urgent, normal)
    @Column(name = "type")
    private String questionType;

    // Date and time when the question is created
    @Column(name = "date")
    private LocalDateTime questionDate;

    // Many-to-One relationship with the Student entity
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentRepositoryModel student;

    // One-to-Many relationship with DocQuestionRepositoryModel for question documents
    @OneToMany(mappedBy = "question",cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<DocQuestionRepositoryModel> docs = new ArrayList<>();

    // One-to-Many relationship with ResponseRepositoryModel for responses to the question
    @OneToMany(mappedBy = "question", orphanRemoval = true)
    private List<ResponseRepositoryModel> responses;

    // PrePersist method to set the question date before persisting in the database
    @PrePersist
    public void prePersist() {
        this.questionDate = LocalDateTime.now();
    }

}
