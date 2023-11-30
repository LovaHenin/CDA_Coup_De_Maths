package com.simplon.coupdemaths.controllers.question;

import com.simplon.coupdemaths.dto.QuestionDto;
import com.simplon.coupdemaths.mapper.CdmMapper;
import com.simplon.coupdemaths.services.question.QuestionService;
import com.simplon.coupdemaths.services.question.QuestionServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;


    @GetMapping
    public List<QuestionDto> getAllQuestions() {
        List<QuestionServiceModel> questions = questionService.getAll();/*
        List<QuestionDto> questionDtos = questions.stream().map((value)->CdmMapper.INSTANCE.serviceToDto(value)).collect(Collectors.toList());

        return questionDtos;*/
        return null;
    }

    @PostMapping
    public boolean newQuestion(@RequestBody QuestionDto questionDto){
/*
        QuestionServiceModel questionServiceModel = CdmMapper.INSTANCE.dtoToService(questionDto);
        return questionService.addQuestion(questionServiceModel);*/
        return false;
    }

}
