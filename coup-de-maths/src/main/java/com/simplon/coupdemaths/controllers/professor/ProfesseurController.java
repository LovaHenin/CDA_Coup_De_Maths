package com.simplon.coupdemaths.controllers.professor;

import com.simplon.coupdemaths.controllers.dto.*;
import com.simplon.coupdemaths.mapper.FullMapper;
import com.simplon.coupdemaths.services.model.ProfessorServiceModel;
import com.simplon.coupdemaths.services.model.QuestionServiceModel;
import com.simplon.coupdemaths.services.model.ResponseServiceModel;
import com.simplon.coupdemaths.services.model.StudentServiceModel;
import com.simplon.coupdemaths.services.professor.ProfessorService;
import com.simplon.coupdemaths.services.question.QuestionService;
import com.simplon.coupdemaths.services.response.ResponseService;
import com.simplon.coupdemaths.services.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/professor")
public class ProfesseurController {

    @Autowired
    ProfessorService professorService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private QuestionService questionService;

    @Autowired
    private ResponseService responseService;


    @PostMapping
    public boolean addResponseByProfessor(@RequestBody ResponseDto responseDto){

        ResponseServiceModel responseServiceModel = FullMapper.INSTANCE.responseDtoToResponseService(responseDto);
        return responseService.addResponseByProfessor(responseServiceModel);
    }


    @GetMapping("{id}")
    public ProfessorDto findById(@PathVariable("id") Long id){
        ProfessorServiceModel professorServiceModel = professorService.findById(id);
        ProfessorDto professor = FullMapper.INSTANCE.professorServiceToProfessorDto(professorServiceModel);
        return professor;
    }

    @GetMapping("/student")
    public List<StudentDto> findAllStudent(){
        List<StudentServiceModel> studentServiceModels = studentService.getAll();
        List<StudentDto> studentDtos = studentServiceModels.stream().map(FullMapper.INSTANCE::studentServiceToStudentDto).collect(Collectors.toList());
        return studentDtos;
    }
    @GetMapping("/questions")
    public List<QuestionDto> findAllQuestion(){
        List<QuestionServiceModel> questionServiceModels = questionService.getAll();
        List<QuestionDto> questionDtos = questionServiceModels.stream().map(FullMapper.INSTANCE::questionServiceToQuestionDto).collect(Collectors.toList());
        return questionDtos;
    }

}
