package com.simplon.coupdemaths.repositories.doc;
import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name="document_question")
public class DocQuestionRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
