package com.simplon.coupdemaths.services.student;

import com.simplon.coupdemaths.mapper.CdmMapper;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepository;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.question.QuestionRepository;
import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepository;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import com.simplon.coupdemaths.services.question.QuestionServiceModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private DocQuestionRepository docQuestionRepository;


//    public List<StudentServiceModel> getAll() {
//        List<StudentRepositoryModel> studentRepositoryModels = studentRepository.findAll();
//        return studentRepositoryModels.stream().map(CdmMapper.INSTANCE::studentrepoToStudentService).collect(Collectors.toList());
//
//    }

    public boolean insererStudent(StudentServiceModel studentServiceModel) {

//
//        StudentRepositoryModel studentRepositoryModel1=studentRepository.save(new StudentRepositoryModel(
//                studentServiceModel.getId(),studentServiceModel.getName(),studentServiceModel.getEmail(),studentServiceModel.getPassword(),studentServiceModel.getCredits()
//                )
//        );
//        return studentRepositoryModel1!=null;
        return false;
    }

    public boolean addQuestionByStudent(QuestionServiceModel questionServiceModel) {

        // Retrieve the student from the database
        StudentRepositoryModel student = studentRepository.findById(questionServiceModel.getStudentId())
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + questionServiceModel.getStudentId()));

        StudentServiceModel studentServiceModel = CdmMapper.INSTANCE.repoToService(student);

        // Associate the student with the question
        questionServiceModel.setStudent(studentServiceModel);


        QuestionRepositoryModel questionRepositoryModel = CdmMapper.INSTANCE.questionServiceModelToQuestionRepositoryModel(questionServiceModel);


        for (DocQuestionRepositoryModel doc : questionRepositoryModel.getDocs()) {
            doc.setQuestion(questionRepositoryModel);
//            docQuestionRepository.save(doc); // plus necessaire car on a utiliser cascade dans l'entité
        }

        questionRepository.save(questionRepositoryModel);
        return true;
    }

}
