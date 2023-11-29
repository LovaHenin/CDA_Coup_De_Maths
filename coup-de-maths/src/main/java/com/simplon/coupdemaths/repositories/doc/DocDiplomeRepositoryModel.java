package com.simplon.coupdemaths.repositories.doc;

import com.simplon.coupdemaths.repositories.professor.ProfessorRepositoryModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="document_diplome")
public class DocDiplomeRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String documentName;
    @Column(name = "path")
    private String documentPath;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorRepositoryModel professor;

}
