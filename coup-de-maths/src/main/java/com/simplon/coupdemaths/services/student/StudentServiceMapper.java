package com.simplon.coupdemaths.services.student;


import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.services.student.model.QuestionServiceModel;
import com.simplon.coupdemaths.services.student.model.StudentServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentServiceMapper {
    StudentServiceMapper INSTANCE = Mappers.getMapper(StudentServiceMapper.class);

   // @Mapping(target = "docs.question",ignore = true)
    QuestionRepositoryModel questionServiceModelToQuestionRepositoryModel(QuestionServiceModel questionServiceModel);

}
