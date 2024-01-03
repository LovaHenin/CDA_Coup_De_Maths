package com.simplon.coupdemaths.repositories.response;
import com.simplon.coupdemaths.repositories.doc.DocResponseRepositoryModel;
import com.simplon.coupdemaths.repositories.professor.ProfessorRepositoryModel;
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
    // Unique identifier for the response
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Text content of the response
    @Column(name = "response", columnDefinition = "LONGTEXT")
    private String response;

    // Date and time when the response was submitted
    @Column(name = "date")
    private LocalDateTime responseDate;

    // Associated question to which the response is provided
    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionRepositoryModel question;

    // List of documents related to the response

    @OneToMany(mappedBy = "response",cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<DocResponseRepositoryModel> docs = new ArrayList<>();

    // Professor who submitted the response
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorRepositoryModel professor;

    // PrePersist method to set the response date before persisting in the database
    @PrePersist
    public void prePersist() {
        this.responseDate = LocalDateTime.now();
    }

}
