package com.simplon.coupdemaths.controllers.question;

import com.simplon.coupdemaths.controllers.dto.QuestionDto;
import com.simplon.coupdemaths.mapper.FullMapper;
import com.simplon.coupdemaths.services.question.QuestionService;
import com.simplon.coupdemaths.services.model.QuestionServiceModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/question")
public class QuestionController {

    @Autowired
    private  QuestionService questionService;

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


}
