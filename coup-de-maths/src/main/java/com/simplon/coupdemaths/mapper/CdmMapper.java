package com.simplon.coupdemaths.mapper;

import com.simplon.coupdemaths.dto.*;
import com.simplon.coupdemaths.repositories.doc.DocDiplomeRepositoryModel;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.doc.DocResponseRepositoryModel;
import com.simplon.coupdemaths.repositories.professor.ProfessorRepositoryModel;
import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.response.ResponseRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import com.simplon.coupdemaths.repositories.transaction.TransactionRepositoryModel;
import com.simplon.coupdemaths.services.doc.DocDiplomeServiceModel;
import com.simplon.coupdemaths.services.doc.DocQuestionServiceModel;
import com.simplon.coupdemaths.services.doc.DocResponseServiceModel;
import com.simplon.coupdemaths.services.professor.ProfessorServiceModel;
import com.simplon.coupdemaths.services.question.QuestionServiceModel;
import com.simplon.coupdemaths.services.response.ResponseServiceModel;
import com.simplon.coupdemaths.services.student.StudentServiceModel;
import com.simplon.coupdemaths.services.transaction.TransactionServiceModel;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL )
public interface CdmMapper {
    CdmMapper INSTANCE = Mappers.getMapper(CdmMapper.class);

                  /*                   // BDD to the Front
    /*
    List<QuestionServiceModel> repoToService(List<QuestionRepositoryModel> questionRepositoryModels);
    List<QuestionRepositoryModel> serviceToRepo(List<QuestionServiceModel> questionServiceModels);

    List<QuestionDto>  serviceToDto(List<QuestionServiceModel> questionServiceModels);

    List<QuestionServiceModel>  dtoToService (List<QuestionDto> questionDtos);

    //Student
    /*
    @Mapping(source="questions", target="questions", qualifiedByName = "typeToOptionalList")
    @Mapping(source="transactions", target="transactions", qualifiedByName = "typeToOptionalList")
    StudentServiceModel repoToService(StudentRepositoryModel studentRepositoryModel);
/

    StudentDto serviceToDto(StudentServiceModel studentServiceModel);

    //professor
    //ProfessorServiceModel repoToService(ProfessorRepositoryModel professorRepositoryModel);
    ProfessorDto serviceToDto(ProfessorServiceModel professorServiceModel);

    // response
    //ResponseServiceModel repoToService(ResponseRepositoryModel responseRepositoryModel);
    ResponseDto serviceToDto(ResponseServiceModel responseServiceModel);

    //DocDiplome
    //DocDiplomeServiceModel repoToService(DocDiplomeRepositoryModel docDiplomeRepositoryModel);
    DocDiplomeDto serviceToDto(DocDiplomeServiceModel docDiplomeServiceModel);
    //Doc Question
    DocQuestionServiceModel repoToservice (DocQuestionRepositoryModel docQuestionRepositoryModel);
    DocQuestionDto serviceToDto(DocQuestionServiceModel docQuestionServiceModel);

    //DocResponse
    //DocResponseServiceModel repoToService(DocResponseRepositoryModel docResponseRepositoryModel);
    DocResponseDto serviceToDto(DocResponseServiceModel docResponseServiceModel);
    //Transaction
    //TransactionServiceModel repoToService(TransactionRepositoryModel transactionRepositoryModel);
    TransactionDto serviceToDto(TransactionServiceModel transactionServiceModel);


                                        //Front to BDD


    // Student


    StudentServiceModel dtoToService(StudentDto studentDto);


    @Mapping(source="questions", target="questions", qualifiedByName = "optionalToTypeList")
    @Mapping(source="transactions", target="transactions", qualifiedByName = "optionalToTypeList")
    StudentRepositoryModel serviceToRepo(StudentServiceModel studentServiceModel);

    // Professor
    ProfessorServiceModel dtoToService(ProfessorDto professorDto);
    ProfessorRepositoryModel serviceToRepo(ProfessorServiceModel professorServiceModel);


    // Question
    @Mapping(source="studentId", target="studentId", qualifiedByName = "typeToOptional")
    QuestionServiceModel dtoToService(QuestionDto questionDto);

    @Mapping(source="student", target="student", qualifiedByName = "optionalToType")
    QuestionRepositoryModel serviceToRepo(QuestionServiceModel questionServiceModel);

    //Question
    @Mapping(source="student", target="student", qualifiedByName = "typeToOptional")
    QuestionServiceModel repoToService(QuestionRepositoryModel questionRepositoryModel);

    @Mapping(source="studentId", target="studentId", qualifiedByName = "optionalToType")
    QuestionDto serviceToDto(QuestionServiceModel questionServiceModel);

    // Response
    ResponseServiceModel dtoToService(ResponseDto responseDto);
    ResponseRepositoryModel serviceToRepo(ResponseServiceModel responseServiceModel);

    // DocDiplome
    DocDiplomeServiceModel dtoToService(DocDiplomeDto docDiplomeDto);
    DocDiplomeRepositoryModel serviceToRepo(DocDiplomeServiceModel docDiplomeServiceModel);

    // DocQuestion
    DocQuestionServiceModel dtoToService(DocQuestionDto docQuestionDto);
    DocQuestionRepositoryModel serviceToRepo(DocQuestionServiceModel docQuestionServiceModel);

    // DocResponse
    DocResponseServiceModel dtoToService(DocResponseDto docResponseDto);
    DocResponseRepositoryModel serviceToRepo(DocResponseServiceModel docResponseServiceModel);

    // Transaction
    TransactionServiceModel dtoToService(TransactionDto transactionDto);
    TransactionRepositoryModel serviceToRepo(TransactionServiceModel transactionServiceModel);

    @Named("optionalToType")
    default <T> T optionalToType(Optional<T> source) throws Exception {
        return source.orElse(null);
    }
    @Named("typeToOptional")
    default <T> Optional<T> typeToOptional(T source) throws Exception {
        return Optional.ofNullable(source);
    }
    @Named("optionalToTypeList")
    default <T> List<T> optionalToTypeList(Optional<List<T>> source) throws Exception {
        return source.orElse(null);
    }
    @Named("typeToOptionalList")
    default <T> Optional<List<T>> typeToOptionalList(List<T> source) throws Exception {
        return Optional.ofNullable(source);
    }
    */
}
