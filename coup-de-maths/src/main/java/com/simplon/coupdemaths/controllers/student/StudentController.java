package com.simplon.coupdemaths.controllers.student;

import com.simplon.coupdemaths.controllers.student.dto.QuestionDto;
import com.simplon.coupdemaths.dto.StudentDto;
import com.simplon.coupdemaths.services.question.QuestionService;
import com.simplon.coupdemaths.services.student.model.QuestionServiceModel;
import com.simplon.coupdemaths.services.student.StudentService;
import com.simplon.coupdemaths.services.student.model.StudentServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

       // return studentService.insererStudent(studentServiceModel);
    return false;
}

    @PostMapping("/{id}/questions")
    public boolean AddQuestionByStudent(@PathVariable Long id, @RequestBody QuestionDto questionDto) {

       QuestionServiceModel questionServiceModel = StudentMapper.INSTANCE.questionDtoToQuestionServiceModel(questionDto);


        return studentService.addQuestionByStudent(questionServiceModel);

    }

}
