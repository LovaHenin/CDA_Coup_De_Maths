package com.simplon.coupdemaths.controllers.question;

import com.simplon.coupdemaths.controllers.student.dto.QuestionDto;
import com.simplon.coupdemaths.controllers.student.dto.StudentDto;
import com.simplon.coupdemaths.mapper.FullMapper;
import com.simplon.coupdemaths.services.question.QuestionService;
import com.simplon.coupdemaths.services.student.StudentService;
import com.simplon.coupdemaths.services.student.model.QuestionServiceModel;
import com.simplon.coupdemaths.services.student.model.StudentServiceModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public List<QuestionDto> findAll(){
        List<QuestionServiceModel> questionServiceModels = questionService.getAll();
        List<QuestionDto> questionDtos = questionServiceModels.stream().map(FullMapper.INSTANCE::questionServiceToQuestionDto).collect(Collectors.toList());
        return questionDtos;
    }

    @GetMapping("{id}")
    public QuestionDto findById(@PathVariable("id") Long id){
        QuestionServiceModel questionServiceModel = questionService.findById(id);
        QuestionDto questionDto = FullMapper.INSTANCE.questionServiceToQuestionDto(questionServiceModel);
        return questionDto;
    }

    @PostMapping
    public boolean newStudent(@RequestBody QuestionDto questionDto){
        QuestionServiceModel questionServiceModel = FullMapper.INSTANCE.questionDtoToQuestionService(questionDto);
        return questionService.add(questionServiceModel);
    }
}
