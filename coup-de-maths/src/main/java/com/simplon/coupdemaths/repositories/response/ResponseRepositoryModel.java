package com.simplon.coupdemaths.repositories.response;
import com.simplon.coupdemaths.repositories.doc.DocResponseRepositoryModel;
import com.simplon.coupdemaths.repositories.professor.Professor;
import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="response")
public class ResponseRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "response")
    private String response;
    @Column(name = "date")
    private LocalDateTime responseDate;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionRepositoryModel question;

    @OneToMany(mappedBy = "response", orphanRemoval = true)
    private List<DocResponseRepositoryModel> docs = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @PrePersist
    public void prePersist(){
        this.responseDate = LocalDateTime.now();
    }

}
