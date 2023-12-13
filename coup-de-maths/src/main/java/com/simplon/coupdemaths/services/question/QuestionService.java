package com.simplon.coupdemaths.services.question;

import com.simplon.coupdemaths.mapper.FullMapper;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepository;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.question.QuestionRepository;
import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepository;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import com.simplon.coupdemaths.services.model.QuestionServiceModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    private  QuestionRepository questionRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private  DocQuestionRepository docQuestionRepository;



    public List<QuestionServiceModel> getAll(){
        List<QuestionRepositoryModel> questionRepositoryModels = questionRepository.findAll();
        List<QuestionServiceModel> questionServiceModels = questionRepositoryModels.stream().map(FullMapper.INSTANCE::questionRepositoryToQuestionService).collect(Collectors.toList());
        return questionServiceModels;
    }


    public QuestionServiceModel findById(Long id){
        QuestionRepositoryModel questionRepositoryModel= questionRepository.findById(id).orElseThrow();
        QuestionServiceModel questionServiceModel = FullMapper.INSTANCE.questionRepositoryToQuestionService(questionRepositoryModel);
        return questionServiceModel;
    }


    public boolean addQuestionByStudent(QuestionServiceModel questionServiceModel) {
        QuestionRepositoryModel questionRepositoryModel = FullMapper.INSTANCE.questionServiceToQuestionRepository(questionServiceModel);

        // add student into question
        Long studentId = questionServiceModel.getStudentId();
        StudentRepositoryModel studentRepositoryModel = studentRepository.findById(studentId).get();
        questionRepositoryModel.setStudent(studentRepositoryModel);

        //save question
        QuestionRepositoryModel newQuestionRepositoryModel = questionRepository.save(questionRepositoryModel);

        // save docs
        for(DocQuestionRepositoryModel docQuestionRepositoryModel : newQuestionRepositoryModel.getDocs()){
            docQuestionRepositoryModel.setQuestion(questionRepositoryModel);
            docQuestionRepository.save(docQuestionRepositoryModel);
        }

        return newQuestionRepositoryModel !=null;
    }

}
