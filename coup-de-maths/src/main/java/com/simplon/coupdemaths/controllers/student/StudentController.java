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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/student")
public class StudentController {
    @Autowired
    private  StudentService studentService;
    @Autowired
    private QuestionService questionService;


    @GetMapping("{id}")
    public StudentDto findById(@PathVariable("id") Long id){
        StudentServiceModel studentServiceModel = studentService.findById(id);
        StudentDto student = FullMapper.INSTANCE.studentServiceToStudentDto(studentServiceModel);
        return student;
    }

    @GetMapping("/questions/{id}")
    public QuestionDto getQuestionById(@PathVariable("id") Long questionId){
        QuestionServiceModel questionServiceModel = questionService.getQuestionById(questionId);
        return FullMapper.INSTANCE.questionServiceToQuestionDto(questionServiceModel);
    }

    @PostMapping("/questions") // modifier
    public boolean addQuestionByStudent(
            @RequestParam(name = "studentId") Long studentId,
            @RequestParam(name = "question",  required = true) String question,
            @RequestParam(name = "level",  required = true) String level,
            @RequestParam(name = "questionType",  required = true) String questionType,
            @RequestParam(name = "documentName",  required = false) String documentName,
            @RequestPart(name = "documentFile", required = false) MultipartFile documentFile
            ){
        QuestionDto questionDto = new QuestionDto(question, level, questionType, studentId);
        QuestionServiceModel questionServiceModel = FullMapper.INSTANCE.questionDtoToQuestionService(questionDto);
        return questionService.addQuestionByStud(questionServiceModel, documentName, documentFile);
    }

    @PutMapping("/questions/{questionId}") // modifier
    public boolean updateQuestion(
            @PathVariable("questionId") Long questionId,
            @RequestParam(name = "question",  required = true) String question,
            @RequestParam(name = "level",  required = true) String level,
            @RequestParam(name = "questionType",  required = true) String questionType,
            @RequestParam(name = "documentName",  required = false) String documentName,
            @RequestPart(name = "documentFile", required = false) MultipartFile documentFile
    ){
        QuestionDto questionDto = new QuestionDto(question, level, questionType);
        QuestionServiceModel questionServiceModel = FullMapper.INSTANCE.questionDtoToQuestionService(questionDto);
        return questionService.updateQuestionByStud(questionId, questionServiceModel, documentName, documentFile);
    }

//    @PutMapping("/questions/{questionId}")
//    public boolean updateQuestion(@PathVariable Long questionId, @RequestBody QuestionDto questionDto){
//        questionDto.setId(questionId);
//
//        QuestionServiceModel questionServiceModel = FullMapper.INSTANCE.questionDtoToQuestionService(questionDto);
//        return questionService.updateQuestion(questionServiceModel);
//    }


    @DeleteMapping("/questions/{questionId}")
    public void deleteQuestion(@PathVariable Long questionId) {
        questionService.deleteQuestion(questionId);
    }

}
