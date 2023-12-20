package com.simplon.coupdemaths.services.response;

import com.simplon.coupdemaths.mapper.FullMapper;
import com.simplon.coupdemaths.repositories.doc.DocResponseRepository;
import com.simplon.coupdemaths.repositories.doc.DocResponseRepositoryModel;
import com.simplon.coupdemaths.repositories.professor.ProfessorRepository;
import com.simplon.coupdemaths.repositories.professor.ProfessorRepositoryModel;
import com.simplon.coupdemaths.repositories.question.QuestionRepository;
import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.response.ResponseRepository;
import com.simplon.coupdemaths.repositories.response.ResponseRepositoryModel;
import com.simplon.coupdemaths.services.model.ResponseServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {
    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    private DocResponseRepository docResponseRepository;

    public boolean addResponseByProfessor(ResponseServiceModel responseServiceModel) {
        ResponseRepositoryModel responseRepositoryModel = FullMapper.INSTANCE.responseServiceToResponseRepository(responseServiceModel);

        // add professor into response
        Long professorId = responseServiceModel.getProfessorId();
        ProfessorRepositoryModel professorRepositoryModel = professorRepository.findById(professorId).get();
        responseRepositoryModel.setProfessor(professorRepositoryModel);

        //add question into response
        Long questionId = responseServiceModel.getQuestionId();
        QuestionRepositoryModel questionRepositoryModel =questionRepository.findById(questionId).get();
        responseRepositoryModel.setQuestion(questionRepositoryModel);

         // save response

       ResponseRepositoryModel newResponseRepositoryModel = responseRepository.save(responseRepositoryModel);

       // save docs

        for(DocResponseRepositoryModel docResponseRepositoryModel :newResponseRepositoryModel.getDocs()){
            docResponseRepositoryModel.setResponse(responseRepositoryModel);
            docResponseRepository.save(docResponseRepositoryModel);
        }


        return  newResponseRepositoryModel !=null;
    }

}
