package com.simplon.coupdemaths.services.professor;

import com.simplon.coupdemaths.mapper.FullMapper;
import com.simplon.coupdemaths.repositories.professor.ProfessorRepository;
import com.simplon.coupdemaths.repositories.professor.ProfessorRepositoryModel;
import com.simplon.coupdemaths.services.model.ProfessorServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;
    public boolean addProfessor(ProfessorServiceModel professorServiceModel) {
        ProfessorRepositoryModel professorRepositoryModel = FullMapper.INSTANCE.professorServiceToProfessorRepository(professorServiceModel);
        ProfessorRepositoryModel newProfessorRepositoryModel = professorRepository.save(professorRepositoryModel);
        return newProfessorRepositoryModel != null;

    }
}
