package com.simplon.coupdemaths.services.doc;

import com.simplon.coupdemaths.mapper.CdmMapper;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepository;
import com.simplon.coupdemaths.repositories.doc.DocQuestionRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocQuestionService {
    @Autowired
    private DocQuestionRepository docQuestionRepository;

    public List<DocQuestionServiceModel> getAll(){
        List<DocQuestionRepositoryModel>docQuestionRepositoryModels=docQuestionRepository.findAll();
        return docQuestionRepositoryModels.stream().map((value)-> CdmMapper.INSTANCE.repoToservice(value)).collect(Collectors.toList());
    }
}
