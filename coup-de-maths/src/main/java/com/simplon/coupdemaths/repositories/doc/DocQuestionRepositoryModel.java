package com.simplon.coupdemaths.repositories.doc;

import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "document_question")
public class DocQuestionRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String documentName;

    @Column(name = "path")
    private String documentPath;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionRepositoryModel question;

    public DocQuestionRepositoryModel() {
    }
}
