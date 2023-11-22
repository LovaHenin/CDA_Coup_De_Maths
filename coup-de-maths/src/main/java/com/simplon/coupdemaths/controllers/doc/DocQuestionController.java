package com.simplon.coupdemaths.controllers.doc;

import com.simplon.coupdemaths.controllers.question.QuestionMapper;
import com.simplon.coupdemaths.services.doc.DocQuestionService;
import com.simplon.coupdemaths.services.doc.DocQuestionServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("docquest")
public class DocQuestionController {
    @Autowired
    private DocQuestionService docQuestionService;

    @GetMapping
    public List<DocQuestionDto> findAll(){
        List<DocQuestionServiceModel> docQuestionServiceModels =docQuestionService.getAll();
        List<DocQuestionDto> docQuestionDtos= docQuestionServiceModels.stream().map((value)->DocQuestionMapper.INSTANCE.serviceToDto(value)).collect(Collectors.toList());
        return docQuestionDtos;
    }
}
