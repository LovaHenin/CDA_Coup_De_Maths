package com.simplon.coupdemaths.mapper;

import com.simplon.coupdemaths.controllers.dto.*;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.doc.DocResponseRepositoryModel;
import com.simplon.coupdemaths.repositories.professor.ProfessorRepositoryModel;
import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.response.ResponseRepositoryModel;
import com.simplon.coupdemaths.repositories.securiry.RoleRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import com.simplon.coupdemaths.repositories.transaction.TransactionRepositoryModel;
import com.simplon.coupdemaths.services.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FullMapper {

    FullMapper INSTANCE = Mappers.getMapper(FullMapper.class);

    // ****************************
    //           ROLES
    // ****************************
    // dto --> service
    RoleServiceModel roleDtoToRoleService(RoleDto roleDto);

    // service --> repository
    RoleRepositoryModel RoleServiceToRoleRepository(RoleServiceModel roleServiceModel);

    // repository --> service
    RoleServiceModel roleRepositoryToRoleService(RoleRepositoryModel roleRepositoryModel);

    // service --> dto
    RoleDto roleServiceToRoleDto(RoleServiceModel roleServiceModel);


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

    // service --> dto
    StudentDtoLight studentServiceToStudentDtoLight(StudentServiceModel studentServiceModel);



    // ****************************
    //            QUESTIONS
    // ****************************
    // dto --> service
    QuestionServiceModel questionDtoToQuestionService(QuestionDto questionDto);

    // service --> repository
    QuestionRepositoryModel questionServiceToQuestionRepository(QuestionServiceModel questionServiceModel);


    // repository --> service
    @Mapping(target= "student", ignore = true)
    QuestionServiceModel  questionRepositoryToQuestionService(QuestionRepositoryModel questionRepositoryModel);

    // service --> dto
    QuestionDto questionServiceToQuestionDto(QuestionServiceModel questionServiceModel);


    // ****************************
    //            RESPONSES
    // ****************************
    @Mapping(target= "question",ignore = true)
    @Mapping(target= "professor",ignore = true)
    ResponseServiceModel responseRepositoryToResponseService(ResponseRepositoryModel responseRepositoryModel);

    //dto=>service
    ResponseServiceModel responseDtoToResponseService(ResponseDto responseDto);

    // service=>repository
    ResponseRepositoryModel responseServiceToResponseRepository(ResponseServiceModel responseServiceModel);

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

    // dto --> service
    ProfessorServiceModel professorDtoToProfessorService (ProfessorDto professorDto);

    // service --> repository
    ProfessorRepositoryModel professorServiceToProfessorRepository(ProfessorServiceModel professorServiceModel);

    //repo --> service
    ProfessorServiceModel professorRepositoryToProfessorService(ProfessorRepositoryModel professorRepositoryModel);

    // service --> dto
    ProfessorDto professorServiceToProfessorDto(ProfessorServiceModel professorServiceModel);


    // ****************************
    //         TRANSACTION
    // ****************************

    // dto --> service
    TransactionServiceModel professorDtoToTransactionService (TransactionDto professorDto);

    // service --> repository
    TransactionRepositoryModel TransactionServiceToTransactionRepository(TransactionServiceModel transactionServiceModel);

    //repo --> service
    TransactionServiceModel transactionRepositoryToTransactionService(TransactionRepositoryModel transactionRepositoryModel);

    // service --> dto
    TransactionDto transactionServiceModelToTransactionDto(TransactionServiceModel transactionServiceModel);
}
