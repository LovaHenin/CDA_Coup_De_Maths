package com.simplon.coupdemaths.services.student;

import com.simplon.coupdemaths.mapper.FullMapper;
import com.simplon.coupdemaths.repositories.securiry.OwnerRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepository;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import com.simplon.coupdemaths.services.model.StudentServiceModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // avec final
public class StudentService {

    private final StudentRepository studentRepository;


    public List<StudentServiceModel> getAll(){
        List<StudentRepositoryModel> studentRepositoryModels = studentRepository.findAll();
        List<StudentServiceModel> studentServiceModels = studentRepositoryModels.stream().map(FullMapper.INSTANCE::studentRepositoryToStudentService).collect(Collectors.toList());
        return studentServiceModels;
    }

    public StudentServiceModel findById(Long id) {
        StudentRepositoryModel studentRepositoryModels = studentRepository.findById(id).orElseThrow();
        StudentServiceModel studentServiceModel = FullMapper.INSTANCE.studentRepositoryToStudentService(studentRepositoryModels);
        return studentServiceModel;
    }

    public boolean insererStudent(StudentServiceModel studentServiceModel) {
        StudentRepositoryModel studentRepositoryModel = FullMapper.INSTANCE.studentServiceToStudentRepository(studentServiceModel);
        StudentRepositoryModel newstudentRepositoryModel = studentRepository.save(studentRepositoryModel);

        return newstudentRepositoryModel != null;
    }
}
