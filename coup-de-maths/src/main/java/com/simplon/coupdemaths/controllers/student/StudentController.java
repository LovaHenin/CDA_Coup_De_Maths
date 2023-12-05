package com.simplon.coupdemaths.controllers.student;

import com.simplon.coupdemaths.controllers.student.dto.QuestionDto;
import com.simplon.coupdemaths.dto.StudentDto;
import com.simplon.coupdemaths.mapper.CdmMapper;
import com.simplon.coupdemaths.services.question.QuestionService;
import com.simplon.coupdemaths.services.student.StudentService;
import com.simplon.coupdemaths.services.question.QuestionServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    QuestionService questionService;





//    @GetMapping
//public List<StudentDto> findAll(){
//   return studentService.getAll().stream().map(CdmMapper.INSTANCE::studentServiceToStudentDto).collect(Collectors.toList());
//}


    @PostMapping
    public boolean newStudent(@RequestBody StudentDto studentDto) {

        // return studentService.insererStudent(studentServiceModel);
        return false;
    }

    @PostMapping("/{id}/questions")
    public boolean AddQuestionByStudent(@PathVariable Long id, @RequestBody QuestionDto questionDto) {

        QuestionServiceModel questionServiceModel = CdmMapper.INSTANCE.questionDtoToQuestionServiceModel(questionDto);


        return studentService.addQuestionByStudent(questionServiceModel);

    }

}
