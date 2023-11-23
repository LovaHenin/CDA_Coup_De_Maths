package com.simplon.coupdemaths.controllers.doc;

import com.simplon.coupdemaths.repositories.doc.DocQuestionRepositoryModel;
import com.simplon.coupdemaths.services.doc.DocQuestionServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

// @Mapper
public interface DocQuestionMapper {
    DocQuestionMapper INSTANCE = Mappers.getMapper(DocQuestionMapper.class);

    //BDD to the Front
    DocQuestionServiceModel repoToservice (DocQuestionRepositoryModel docQuestionRepositoryModel);
    DocQuestionDto serviceToDto(DocQuestionServiceModel docQuestionServiceModel);
}
