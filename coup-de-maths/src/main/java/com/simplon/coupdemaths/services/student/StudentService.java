package com.simplon.coupdemaths.services.student;

import com.simplon.coupdemaths.dto.QuestionDto;
import com.simplon.coupdemaths.mapper.CdmMapper;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepository;
import com.simplon.coupdemaths.repositories.question.QuestionRepository;
import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepository;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import com.simplon.coupdemaths.services.question.QuestionService;
import com.simplon.coupdemaths.services.question.QuestionServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private QuestionRepository questionRepository;


    public List<StudentServiceModel> getAll(){
        List<StudentRepositoryModel> studentRepositoryModels = studentRepository.findAll();
        //return studentRepositoryModels.stream().map(CdmMapper.INSTANCE::repoToService).collect(Collectors.toList());
        return null;
    }

    public boolean insererStudent(StudentServiceModel studentServiceModel) {


        StudentRepositoryModel studentRepositoryModel1=studentRepository.save(new StudentRepositoryModel(
                studentServiceModel.getId(),studentServiceModel.getName(),studentServiceModel.getEmail(),studentServiceModel.getPassword(),studentServiceModel.getCredits()
                )
        );
        return studentRepositoryModel1!=null;
    }

    public boolean addQuestionByStudent(QuestionServiceModel questionServiceModel) {
        //mapper
        QuestionRepositoryModel questionRepositoryModel = new QuestionRepositoryModel(questionServiceModel.getQuestion(), questionServiceModel.getLevel(), questionServiceModel.getQuestionType(), questionServiceModel.getQuestionDate(), questionServiceModel.getStudentId(), questionServiceModel.getDocs());


        questionRepository.save(questionRepositoryModel);
    }
}
