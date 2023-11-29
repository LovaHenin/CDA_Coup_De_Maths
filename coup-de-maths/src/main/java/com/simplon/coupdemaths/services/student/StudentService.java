package com.simplon.coupdemaths.services.student;

import com.simplon.coupdemaths.mapper.CdmMapper;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepository;
import com.simplon.coupdemaths.repositories.question.QuestionRepository;
import com.simplon.coupdemaths.repositories.student.StudentRepository;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;


    public List<StudentServiceModel> getAll(){
        List<StudentRepositoryModel> studentRepositoryModels = studentRepository.findAll();
        return studentRepositoryModels.stream().map(CdmMapper.INSTANCE::repoToService).collect(Collectors.toList());
    }

    public boolean insererStudent(StudentServiceModel studentServiceModel) {

        StudentRepositoryModel studentRepositoryModel =CdmMapper.INSTANCE.serviceToRepo(studentServiceModel);
        StudentRepositoryModel studentRepositoryModel1=studentRepository.save(studentRepositoryModel);
        return studentRepositoryModel1!=null;
    }
}
