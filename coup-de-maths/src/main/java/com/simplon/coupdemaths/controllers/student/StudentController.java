package com.simplon.coupdemaths.controllers.student;

import com.simplon.coupdemaths.dto.QuestionDto;
import com.simplon.coupdemaths.dto.StudentDto;
import com.simplon.coupdemaths.mapper.CdmMapper;
import com.simplon.coupdemaths.services.question.QuestionService;
import com.simplon.coupdemaths.services.question.QuestionServiceModel;
import com.simplon.coupdemaths.services.student.StudentService;
import com.simplon.coupdemaths.services.student.StudentServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    QuestionService questionService;
    @GetMapping
public List<StudentDto> findAll(){
/*
   return studentService.getAll().stream().map(CdmMapper.INSTANCE::serviceToDto).collect(Collectors.toList());/

 */
        return null;
}
@PostMapping
public  boolean newStudent(@RequestBody StudentDto studentDto){
        StudentServiceModel studentServiceModel = new StudentServiceModel(studentDto.id(),
                studentDto.name(),studentDto.email(),studentDto.password(),studentDto.credits(), Optional.empty(),Optional.empty());
        return studentService.insererStudent(studentServiceModel);
}

    @PostMapping("/{id}/questions")
    public boolean AddQuestionByStudent(@PathVariable Long id, @RequestBody QuestionDto questionDto) {

        QuestionServiceModel questionServiceModel = new QuestionServiceModel(questionDto.question(),questionDto.level(),questionDto.questionDate(),questionDto.studentId(),questionDto.docs());

        return studentService.addQuestionByStudent(questionServiceModel);

    }

}
