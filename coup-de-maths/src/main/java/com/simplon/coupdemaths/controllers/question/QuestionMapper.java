package com.simplon.coupdemaths.controllers.question;

import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.services.question.QuestionServiceModel;
import org.mapstruct.factory.Mappers;

public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    // BDD to the Front
    QuestionServiceModel repoToService(QuestionRepositoryModel questionRepositoryModel);
    QuestionDto serviceToDto(QuestionServiceModel questionServiceModel);
}
