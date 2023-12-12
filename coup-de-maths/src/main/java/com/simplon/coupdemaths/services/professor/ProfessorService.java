package com.simplon.coupdemaths.services.professor;

import com.simplon.coupdemaths.mapper.FullMapper;
import com.simplon.coupdemaths.repositories.professor.ProfessorRepository;
import com.simplon.coupdemaths.repositories.professor.ProfessorRepositoryModel;
import com.simplon.coupdemaths.services.model.ProfessorServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;
    public ProfessorServiceModel findById(Long id) {
        try {
            ProfessorRepositoryModel professorRepositoryModel = professorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Aucun professeur trouvé avec l'ID : " + id));
            ProfessorServiceModel professorServiceModel = FullMapper.INSTANCE.professorRepositoryToProfessorService(professorRepositoryModel);
            return professorServiceModel;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<ProfessorServiceModel> getAll() {
        List<ProfessorRepositoryModel> professorRepositoryModels = professorRepository.findAll();
        List<ProfessorServiceModel> professorServiceModels = professorRepositoryModels.stream().map(FullMapper.INSTANCE::professorRepositoryToProfessorService).collect(Collectors.toList());
        return professorServiceModels;
    }
}
