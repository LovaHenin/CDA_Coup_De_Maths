package com.simplon.coupdemaths.controllers.student;

import com.simplon.coupdemaths.controllers.dto.QuestionDto;
import com.simplon.coupdemaths.controllers.dto.StudentDto;
import com.simplon.coupdemaths.mapper.FullMapper;
import com.simplon.coupdemaths.services.model.QuestionServiceModel;
import com.simplon.coupdemaths.services.question.QuestionService;
import com.simplon.coupdemaths.services.student.StudentService;
import com.simplon.coupdemaths.services.model.StudentServiceModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/student")
public class StudentController {

    private final StudentService studentService;
    @Autowired
    QuestionService questionService;

    @GetMapping
    public List<StudentDto> findAll(){
        List<StudentServiceModel> studentServiceModels = studentService.getAll();
        List<StudentDto> studentDtos = studentServiceModels.stream().map(FullMapper.INSTANCE::studentServiceToStudentDto).collect(Collectors.toList());
       return studentDtos;
    }

    @GetMapping("{id}")
    public StudentDto findById(@PathVariable("id") Long id){
        StudentServiceModel studentServiceModel = studentService.findById(id);
        StudentDto student = FullMapper.INSTANCE.studentServiceToStudentDto(studentServiceModel);
        return student;
    }

//    @PostMapping
//    public boolean newStudent(@RequestBody StudentDto studentDto){
//        StudentServiceModel studentServiceModel = FullMapper.INSTANCE.studentDtoToStudentService(studentDto);
//        return studentService.insererStudent(studentServiceModel);
//    }

    @PostMapping
    public boolean addQuestionByStudent(@RequestBody QuestionDto questionDto){
        QuestionServiceModel questionServiceModel = FullMapper.INSTANCE.questionDtoToQuestionService(questionDto);
        return questionService.addQuestionByStudent(questionServiceModel);
    }

}
