package com.simplon.coupdemaths.controllers.professor;

import com.simplon.coupdemaths.controllers.dto.ProfessorDto;
import com.simplon.coupdemaths.mapper.FullMapper;
import com.simplon.coupdemaths.services.model.ProfessorServiceModel;
import com.simplon.coupdemaths.services.professor.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/professor")
public class ProfesseurController {

    @Autowired
    ProfessorService professorService;
    @PostMapping
    public boolean newProfessor(@RequestBody ProfessorDto professorDto){
        ProfessorServiceModel professorServiceModel = FullMapper.INSTANCE.professorDtoToProfessorService(professorDto);
        return professorService.addProfessor(professorServiceModel);
    }
}
