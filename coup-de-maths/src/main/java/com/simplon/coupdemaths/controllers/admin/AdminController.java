package com.simplon.coupdemaths.controllers.admin;

import com.simplon.coupdemaths.controllers.dto.ProfessorDto;
import com.simplon.coupdemaths.controllers.dto.StudentDto;
import com.simplon.coupdemaths.controllers.dto.StudentDtoLight;
import com.simplon.coupdemaths.mapper.FullMapper;
import com.simplon.coupdemaths.repositories.securiry.OwnerRepositoryModel;
import com.simplon.coupdemaths.services.admin.AdminService;
import com.simplon.coupdemaths.services.model.ProfessorServiceModel;
import com.simplon.coupdemaths.services.model.StudentServiceModel;
import com.simplon.coupdemaths.services.professor.ProfessorService;
import com.simplon.coupdemaths.services.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
    private StudentService studentService;
    @Autowired
    ProfessorService professorService;
    @Autowired
    AdminService adminService;



    @GetMapping("/students/simple")
    public List<StudentDtoLight> findAllStudentsLight(){
        List<StudentServiceModel> studentServiceModels = studentService.getAll();
        List<StudentDtoLight> studentDtos = studentServiceModels.stream().map(FullMapper.INSTANCE::studentServiceToStudentDtoLight).collect(Collectors.toList());
        return studentDtos;
    }

    @GetMapping("/students")
    public List<StudentDto> findAllStudents(){
        List<StudentServiceModel> studentServiceModels = studentService.getAll();
        List<StudentDto> studentDtos = studentServiceModels.stream().map(FullMapper.INSTANCE::studentServiceToStudentDto).collect(Collectors.toList());
        return studentDtos;
    }

    @PutMapping("/users/{id}/role")
    public boolean validateRoleUser (@PathVariable Long id) throws RoleNotFoundException {
        return adminService.validateRoleUser(id);
    }

    @GetMapping("/professors")
    public List<ProfessorDto> findAllProfessors(){
        List<ProfessorServiceModel> professorServiceModels = professorService.getAll();
        List<ProfessorDto> professorDtos = professorServiceModels.stream().map(FullMapper.INSTANCE::professorServiceToProfessorDto).collect(Collectors.toList());
        return professorDtos;
    }
}
