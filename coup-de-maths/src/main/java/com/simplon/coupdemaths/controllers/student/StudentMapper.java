package com.simplon.coupdemaths.controllers.student;

import com.simplon.coupdemaths.controllers.student.dto.QuestionDto;
import com.simplon.coupdemaths.dto.StudentDto;
import com.simplon.coupdemaths.services.student.model.QuestionServiceModel;
import com.simplon.coupdemaths.services.student.model.StudentServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);



  //  @Mapping(target="responses",ignore = true )
    QuestionServiceModel questionDtoToQuestionServiceModel(QuestionDto questionDto);


}
