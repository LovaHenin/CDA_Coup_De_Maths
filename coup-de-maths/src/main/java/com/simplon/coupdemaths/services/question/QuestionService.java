package com.simplon.coupdemaths.services.question;

import com.simplon.coupdemaths.mapper.FullMapper;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepository;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.question.QuestionRepository;
import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepository;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import com.simplon.coupdemaths.services.model.QuestionServiceModel;
import com.simplon.coupdemaths.utils.FileUpload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    private  QuestionRepository questionRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private  DocQuestionRepository docQuestionRepository;

    @Autowired
    private FileUpload fileUpload;



    public List<QuestionServiceModel> getAll(){
        List<QuestionRepositoryModel> questionRepositoryModels = questionRepository.findAll();
        List<QuestionServiceModel> questionServiceModels = questionRepositoryModels.stream().map(FullMapper.INSTANCE::questionRepositoryToQuestionService).collect(Collectors.toList());
        return questionServiceModels;
    }


    public QuestionServiceModel findById(Long id){
        QuestionRepositoryModel questionRepositoryModel = questionRepository.findById(id).orElseThrow();
        QuestionServiceModel questionServiceModel = FullMapper.INSTANCE.questionRepositoryToQuestionService(questionRepositoryModel);
        return questionServiceModel;
    }

    public boolean addQuestionByStud(QuestionServiceModel questionServiceModel, String documentName, MultipartFile documentFile) {
        QuestionRepositoryModel questionRepositoryModel = FullMapper.INSTANCE.questionServiceToQuestionRepository(questionServiceModel);

        // add student into question
        Long studentId = questionServiceModel.getStudentId();
        StudentRepositoryModel studentRepositoryModel = studentRepository.findById(studentId).get();
        questionRepositoryModel.setStudent(studentRepositoryModel);

        // SAVE QUESTION
        QuestionRepositoryModel newQuestionRepositoryModel = questionRepository.save(questionRepositoryModel);

        // Enregistrer le fichier
        if(documentFile != null){
            String fileName = fileUpload.upload(documentFile);
            if (!Objects.equals(fileName, "")){
                // save doc
                DocQuestionRepositoryModel docQuestionRepositoryModel = new DocQuestionRepositoryModel();
                docQuestionRepositoryModel.setDocumentName(documentName);
                docQuestionRepositoryModel.setDocumentPath(fileName);
                docQuestionRepositoryModel.setQuestion(newQuestionRepositoryModel);
                docQuestionRepository.save(docQuestionRepositoryModel);
            }
        }
        return newQuestionRepositoryModel != null;

    }

    public boolean updateQuestionByStud(Long questionId, QuestionServiceModel questionServiceModel, String documentName, MultipartFile documentFile) {
        QuestionRepositoryModel questionRepositoryModel = FullMapper.INSTANCE.questionServiceToQuestionRepository(questionServiceModel);

        QuestionRepositoryModel originalQuestionRepositoryModel = questionRepository.findById(questionId).orElseThrow();
        originalQuestionRepositoryModel.setLevel(questionRepositoryModel.getLevel());
        originalQuestionRepositoryModel.setQuestion(questionRepositoryModel.getQuestion());
        originalQuestionRepositoryModel.setQuestionType(questionRepositoryModel.getQuestionType());

        QuestionRepositoryModel savedQuestionRepositoryModel =  questionRepository.save(questionRepositoryModel);


        // Enregistrer le fichier en mode ajout
        if(documentFile != null){
            String fileName = fileUpload.upload(documentFile);
            if ( !fileName.isEmpty() ){
                // save doc
                DocQuestionRepositoryModel docQuestionRepositoryModel = new DocQuestionRepositoryModel();
                docQuestionRepositoryModel.setDocumentName(documentName);
                docQuestionRepositoryModel.setDocumentPath(fileName);
                docQuestionRepositoryModel.setQuestion(savedQuestionRepositoryModel);
                docQuestionRepository.save(docQuestionRepositoryModel);
            }
        }


        return savedQuestionRepositoryModel != null;
    }

    public QuestionServiceModel getQuestionById(Long questionId) {
        QuestionRepositoryModel questionRepositoryModel = questionRepository.findById(questionId).orElseThrow();
        return FullMapper.INSTANCE.questionRepositoryToQuestionService(questionRepositoryModel);
    }

    public void deleteQuestion(Long questionId) {
        questionRepository.deleteById(questionId);
    }

//    public boolean addQuestionByStudent(QuestionServiceModel questionServiceModel) {
//        QuestionRepositoryModel questionRepositoryModel = FullMapper.INSTANCE.questionServiceToQuestionRepository(questionServiceModel);
//
//        // add student into question
//        Long studentId = questionServiceModel.getStudentId();
//        StudentRepositoryModel studentRepositoryModel = studentRepository.findById(studentId).get();
//        questionRepositoryModel.setStudent(studentRepositoryModel);
//
//        //save question
//        QuestionRepositoryModel newQuestionRepositoryModel = questionRepository.save(questionRepositoryModel);
//
//        // save docs
//        for(DocQuestionRepositoryModel docQuestionRepositoryModel : newQuestionRepositoryModel.getDocs()){
//            docQuestionRepositoryModel.setQuestion(questionRepositoryModel);
//            docQuestionRepository.save(docQuestionRepositoryModel);
//        }
//
//        return newQuestionRepositoryModel !=null;
//    }

//    public boolean updateQuestion(QuestionServiceModel questionServiceModel) {
//        //Mapping
//        QuestionRepositoryModel getQuestion = FullMapper.INSTANCE.questionServiceToQuestionRepository(questionServiceModel);
//
//        QuestionRepositoryModel savedQuestion = questionRepository.findById(questionServiceModel.getId()).orElseThrow();
//
//        savedQuestion.setQuestion(getQuestion.getQuestion());
//        savedQuestion.setLevel(getQuestion.getLevel());
//        savedQuestion.setQuestionType(getQuestion.getQuestionType());
//
//        //save question
//            QuestionRepositoryModel newQuestionRepositoryModel = questionRepository.save(savedQuestion);
//            return newQuestionRepositoryModel !=null;
//    }


}
