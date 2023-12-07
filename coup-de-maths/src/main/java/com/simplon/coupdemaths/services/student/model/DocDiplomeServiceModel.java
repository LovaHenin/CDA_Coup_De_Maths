package com.simplon.coupdemaths.services.student.model;

import com.simplon.coupdemaths.repositories.professor.ProfessorRepositoryModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocDiplomeServiceModel {
    private Long id;
    private String documentName;
    private String documentPath;
    private ProfessorServiceModel professor;
}
