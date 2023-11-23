package com.simplon.coupdemaths.controllers.professor;

import com.simplon.coupdemaths.repositories.professor.ProfessorRepositoryModel;
import com.simplon.coupdemaths.services.professor.ProfessorServiceModel;
import org.mapstruct.factory.Mappers;

public interface ProfessorMapper {
    ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

    // BDD to the Front
    ProfessorServiceModel repoToService(ProfessorRepositoryModel professorRepositoryModel);
    ProfessorDto serviceToDto(ProfessorServiceModel professorServiceModel);

}
