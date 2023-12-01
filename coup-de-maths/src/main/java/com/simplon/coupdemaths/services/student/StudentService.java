package com.simplon.coupdemaths.services.student;

import com.simplon.coupdemaths.mapper.CdmMapper;
import com.simplon.coupdemaths.repositories.question.QuestionRepository;
import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepository;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import com.simplon.coupdemaths.services.student.model.QuestionServiceModel;
import com.simplon.coupdemaths.services.student.model.StudentServiceModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        // Retrieve the student from the database
        StudentRepositoryModel student = studentRepository.findById(questionServiceModel.getStudentId())
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + questionServiceModel.getStudentId()));

        StudentServiceModel studentServiceModel = CdmMapper.INSTANCE.repoToService(student);

        // Associate the student with the question
        questionServiceModel.setStudent(studentServiceModel);


        QuestionRepositoryModel questionRepositoryModel =StudentServiceMapper.INSTANCE.questionServiceModelToQuestionRepositoryModel(questionServiceModel);


        questionRepository.save(questionRepositoryModel);
        return true;
    }

}
