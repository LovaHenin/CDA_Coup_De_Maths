package com.simplon.coupdemaths.controllers.question;

import com.simplon.coupdemaths.dto.QuestionDto;
import com.simplon.coupdemaths.mapper.CdmMapper;
import com.simplon.coupdemaths.services.question.QuestionService;
import com.simplon.coupdemaths.services.question.QuestionServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping
    public boolean newQuestion(@RequestBody QuestionDto questionDto){

        QuestionServiceModel questionServiceModel = CdmMapper.INSTANCE.dtoToService(questionDto);
        return questionService.insererQuestion(questionServiceModel);
    }

}
