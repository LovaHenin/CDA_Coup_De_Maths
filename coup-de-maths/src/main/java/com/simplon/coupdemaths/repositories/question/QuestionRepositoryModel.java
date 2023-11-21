package com.simplon.coupdemaths.repositories.question;

import com.simplon.coupdemaths.enums.LevelEnum;
import com.simplon.coupdemaths.enums.QuestionTypeEnum;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.response.ResponseRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="question")
public class QuestionRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "question")
    private String question;

    @Column(name = "level")
    private LevelEnum level;

    @Column(name = "type")
    private QuestionTypeEnum questionType;

    @Column(name = "date")
    private LocalDateTime questionDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentRepositoryModel student;

    @OneToMany(mappedBy = "question", orphanRemoval = true)
    private List<DocQuestionRepositoryModel> docs = new ArrayList<>();

    @OneToMany(mappedBy = "question", orphanRemoval = true)
    private List<ResponseRepositoryModel> responses = new ArrayList<>();

    @PrePersist
    public void prePersist(){
        this.questionDate = LocalDateTime.now();
    }
}
