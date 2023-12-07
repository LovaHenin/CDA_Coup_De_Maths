package com.simplon.coupdemaths.mapper;

import com.simplon.coupdemaths.controllers.student.dto.QuestionDto;
import com.simplon.coupdemaths.dto.StudentDto;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import com.simplon.coupdemaths.services.doc.DocQuestionServiceModel;
import com.simplon.coupdemaths.services.question.QuestionServiceModel;
import com.simplon.coupdemaths.services.student.StudentServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface CdmMapper {
    CdmMapper INSTANCE = Mappers.getMapper(CdmMapper.class);

    @Mapping(target = "questions", ignore = true)
    @Mapping(target = "transactions", ignore = true)
    StudentServiceModel repoToService(StudentRepositoryModel studentRepositoryModel);


    //Dto=>Service
    QuestionServiceModel questionDtoToQuestionServiceModel(QuestionDto questionDto);

    //Service=>repo
    QuestionRepositoryModel questionServiceModelToQuestionRepositoryModel(QuestionServiceModel questionServiceModel);

    StudentDto studentServiceToStudentDto(StudentServiceModel studentServiceModel);


    DocQuestionRepositoryModel docQuestionserviceToDocQuestionRepo(DocQuestionServiceModel docQuestionServiceModel);


}
