package com.simplon.coupdemaths.services.doc;

import com.simplon.coupdemaths.controllers.doc.DocQuestionMapper;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepository;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepositoryModel;
import com.simplon.coupdemaths.services.question.QuestionServiceModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocQuestionService {
    @Autowired
    DocQuestionRepository docQuestionRepository;

    public List<DocQuestionServiceModel> getAll() {
        List<DocQuestionRepositoryModel> docQuestionRepositoryModels = docQuestionRepository.findAll();
        List<DocQuestionServiceModel> docQuestionServiceModels = docQuestionRepositoryModels.stream().map((value)-> DocQuestionMapper.INSTANCE.repoToservice(value)).collect(Collectors.toList());

                //.stream().map((value)-> DocQuestionMapper.INSTANCE.repoToservice(value)).collect(Collectors.toList());
        return docQuestionServiceModels ;
    }
}
