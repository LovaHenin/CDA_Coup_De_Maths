package com.simplon.coupdemaths.controllers.student.dto;

import com.simplon.coupdemaths.services.student.model.ProfessorServiceModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocDiplomeDto {
    private Long id;
    private String documentName;
    private String documentPath;
    private ProfessorServiceModel professor;
}
