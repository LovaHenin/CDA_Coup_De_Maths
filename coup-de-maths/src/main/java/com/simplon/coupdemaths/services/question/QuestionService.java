package com.simplon.coupdemaths.services.question;

import com.simplon.coupdemaths.repositories.question.QuestionRepository;
import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public List<QuestionServiceModel> getAll() {
        List<QuestionRepositoryModel> questionRepositoryModels = questionRepository.findAll();

/*
        return questionRepositoryModels.stream().map((value)-> CdmMapper.INSTANCE.repoToService(value)).collect(Collectors.toList());*/
        return null;
    }


    public boolean addQuestion(QuestionServiceModel questionServiceModel) {

//        Optional<StudentRepositoryModel> student = studentRepository.findById(questionServiceModel.getStudentId().get());
//        StudentServiceModel studentServiceModel= CdmMapper.INSTANCE.repoToService(student.get());
//
//        questionServiceModel.setStudent(Optional.ofNullable(studentServiceModel) );
//
//
//        QuestionRepositoryModel questionRepositoryModel=CdmMapper.INSTANCE.serviceToRepo(questionServiceModel);
//
//        // si l'id n'est pas sauvegardé tu m'apelle
//
//        QuestionRepositoryModel questionRepositoryModel1 =questionRepository.save(questionRepositoryModel);
//        return  questionRepositoryModel1!=null;
        return true;
    }
}
