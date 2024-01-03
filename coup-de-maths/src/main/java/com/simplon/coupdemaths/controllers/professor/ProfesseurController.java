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
import org.springframework.web.multipart.MultipartFile;

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


//    @PostMapping
//    public boolean addResponseByProfessor(@RequestBody ResponseDto responseDto){
//
//        ResponseServiceModel responseServiceModel = FullMapper.INSTANCE.responseDtoToResponseService(responseDto);
//        return responseService.addResponseByProfessor(responseServiceModel);
//    }


    @PostMapping("/responses")
    public boolean addResponseByProfessor(
            @RequestParam(name = "questionId", required = true) Long questionId,
            @RequestParam(name = "professorId", required = true) Long professorId,
            @RequestParam(name = "response", required = true) String response,
            @RequestParam(name = "documentName", required = false) String documentName,
            @RequestPart(name = "documentFile", required = false) MultipartFile documentFile
    ){

        ResponseDto responseDto = new ResponseDto(response,questionId,professorId);

        ResponseServiceModel responseServiceModel = FullMapper.INSTANCE.responseDtoToResponseService(responseDto);
      return responseService.addResponseByProfessor(responseServiceModel,documentName,documentFile);

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

    @GetMapping("/questions/{id}")
    public QuestionDto findQuestionById(@PathVariable("id") Long id){
        QuestionServiceModel questionServiceModel = questionService.findById(id);
        return FullMapper.INSTANCE.questionServiceToQuestionDto(questionServiceModel);
    }

}
