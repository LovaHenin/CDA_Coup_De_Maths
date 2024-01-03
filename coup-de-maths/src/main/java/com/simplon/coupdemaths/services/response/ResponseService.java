package com.simplon.coupdemaths.services.response;

import com.simplon.coupdemaths.mapper.FullMapper;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.doc.DocResponseRepository;
import com.simplon.coupdemaths.repositories.doc.DocResponseRepositoryModel;
import com.simplon.coupdemaths.repositories.professor.ProfessorRepository;
import com.simplon.coupdemaths.repositories.professor.ProfessorRepositoryModel;
import com.simplon.coupdemaths.repositories.question.QuestionRepository;
import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.response.ResponseRepository;
import com.simplon.coupdemaths.repositories.response.ResponseRepositoryModel;
import com.simplon.coupdemaths.services.model.ResponseServiceModel;
import com.simplon.coupdemaths.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
public class ResponseService {
    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private DocResponseRepository docResponseRepository;
    @Autowired
    private FileUpload fileUpload;

    public ResponseService() {
    }

    public boolean addResponseByProfessor(ResponseServiceModel responseServiceModel, String documentName, MultipartFile documentFile ) {
        ResponseRepositoryModel responseRepositoryModel = FullMapper.INSTANCE.responseServiceToResponseRepository(responseServiceModel);

        // add professor into response
        Long professorId = responseServiceModel.getProfessorId();
        ProfessorRepositoryModel professorRepositoryModel = professorRepository.findById(professorId).get();
        responseRepositoryModel.setProfessor(professorRepositoryModel);

        // add question into response
        Long questionId = responseServiceModel.getQuestionId();
        QuestionRepositoryModel questionRepositoryModel =questionRepository.findById(questionId).get();
        responseRepositoryModel.setQuestion(questionRepositoryModel);

         // save response
       ResponseRepositoryModel newResponseRepositoryModel = responseRepository.save(responseRepositoryModel);

        // Enregistrer le fichier
        if(documentFile != null){
            String fileName = fileUpload.upload(documentFile);
            if (!Objects.equals(fileName, "")){
                // save doc
                DocResponseRepositoryModel docResponseRepositoryModel = new DocResponseRepositoryModel();
                docResponseRepositoryModel.setDocumentName(documentName);
                docResponseRepositoryModel.setDocumentPath(fileName);
                docResponseRepositoryModel.setResponse(responseRepositoryModel);
                docResponseRepository.save(docResponseRepositoryModel);
            }
        }

        return  newResponseRepositoryModel != null;
    }

}
