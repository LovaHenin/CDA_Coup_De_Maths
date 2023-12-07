package com.simplon.coupdemaths.mapper;

import com.simplon.coupdemaths.controllers.student.dto.QuestionDto;
import com.simplon.coupdemaths.controllers.student.dto.StudentDto;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.doc.DocResponseRepositoryModel;
import com.simplon.coupdemaths.repositories.professor.ProfessorRepositoryModel;
import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.response.ResponseRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import com.simplon.coupdemaths.services.student.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FullMapper {

    FullMapper INSTANCE = Mappers.getMapper(FullMapper.class);

    // ****************************
    //            STUDENTS
    // ****************************
    // dto --> service
    StudentServiceModel studentDtoToStudentService(StudentDto studentDto);

    // service --> repository
    StudentRepositoryModel studentServiceToStudentRepository(StudentServiceModel studentServiceModel);

//    @Mapping(target= "questions.student",ignore = true)
    // repository --> service
    StudentServiceModel studentRepositoryToStudentService(StudentRepositoryModel studentRepositoryModel);

    // service --> dto
    StudentDto studentServiceToStudentDto(StudentServiceModel studentServiceModel);


    // ****************************
    //            QUESTIONS
    // ****************************
    // dto --> service
    QuestionServiceModel questionDtoToQuestionService(QuestionDto questionDto);

    // service --> repository
    QuestionRepositoryModel questionServiceToQuestionRepository(QuestionServiceModel questionServiceModel);

    @Mapping(target= "student",ignore = true)
    // repository --> service
    QuestionServiceModel  questionRepositoryToQuestionServiceModel(QuestionRepositoryModel questionRepositoryModel);

    // service --> dto
    QuestionDto questionServiceToQuestionDto(QuestionServiceModel questionServiceModel);


    // ****************************
    //            RESPONSES
    // ****************************
    ResponseServiceModel responseRepositoryToResponseService(ResponseRepositoryModel responseRepositoryModel);


    // ****************************
    //         DOC QUESTIONS
    // ****************************
    DocQuestionServiceModel DocQuestionRepositoryToDocQuestionService (DocQuestionRepositoryModel docQuestionRepositoryModel);
    List<DocQuestionServiceModel> DocQuestionRepositoryToDocQuestionService (List<DocQuestionRepositoryModel> docQuestionRepositoryModel);


    // ****************************
    //         DOC RESPONSES
    // ****************************
    DocResponseServiceModel docResponseRepositoryToDocResponseService(DocResponseRepositoryModel docResponseRepositoryModel);


    // ****************************
    //         PROFESSEUR
    // ****************************
    ProfessorServiceModel professorRepositoryToProfessorService(ProfessorRepositoryModel professorRepositoryModel);

}
