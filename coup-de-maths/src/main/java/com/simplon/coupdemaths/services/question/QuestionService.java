package com.simplon.coupdemaths.services.question;

import com.simplon.coupdemaths.mapper.FullMapper;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepository;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepositoryModel;
import com.simplon.coupdemaths.repositories.question.QuestionRepository;
import com.simplon.coupdemaths.repositories.question.QuestionRepositoryModel;
import com.simplon.coupdemaths.services.model.QuestionServiceModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    private final DocQuestionRepository docQuestionRepository;

    public List<QuestionServiceModel> getAll(){
        List<QuestionRepositoryModel> questionRepositoryModels = questionRepository.findAll();
        List<QuestionServiceModel> questionServiceModels = questionRepositoryModels.stream().map(FullMapper.INSTANCE::questionRepositoryToQuestionService).collect(Collectors.toList());
        return questionServiceModels;
    }

    public QuestionServiceModel findById(Long id) {
        QuestionRepositoryModel questionRepositoryModel = questionRepository.findById(id).orElseThrow();
        QuestionServiceModel questionServiceModel = FullMapper.INSTANCE.questionRepositoryToQuestionService(questionRepositoryModel);
        return questionServiceModel;
    }

    public boolean addQuestionByStudent(QuestionServiceModel questionServiceModel) {
        QuestionRepositoryModel questionRepositoryModel = FullMapper.INSTANCE.questionServiceToQuestionRepository(questionServiceModel);

        List<DocQuestionRepositoryModel> docQuestionRepositoryModels = questionRepositoryModel.getDocs();

        for(DocQuestionRepositoryModel docQuestionRepositoryModel : docQuestionRepositoryModels){
            docQuestionRepositoryModel.setQuestion(questionRepositoryModel);
        }

        QuestionRepositoryModel newQuestionRepositoryModel = questionRepository.save(questionRepositoryModel);



//        docQuestionRepositoryModels.stream().map((value) -> docQuestionRepository.save(value));

        return newQuestionRepositoryModel !=null;
    }
}
