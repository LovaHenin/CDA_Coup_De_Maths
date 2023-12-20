package com.simplon.coupdemaths.services.security;

import com.simplon.coupdemaths.repositories.professor.ProfessorRepository;
import com.simplon.coupdemaths.repositories.professor.ProfessorRepositoryModel;
import com.simplon.coupdemaths.repositories.securiry.RoleRepository;
import com.simplon.coupdemaths.repositories.securiry.RoleRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepository;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;

@Service
public class SecurityService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;

    public ProfessorRepositoryModel registerProfessor(String name, String email, String password) throws RoleNotFoundException {

        ProfessorRepositoryModel professor = new ProfessorRepositoryModel();
        professor.setName(name);
        professor.setEmail(email);

        RoleRepositoryModel role = roleRepository.findById(5L).orElseThrow(() -> new RoleNotFoundException("Le rôle avec l'ID spécifié n'a pas été trouvé."));
        professor.getRoles().add(role);

        professor.setCredits(5);
        professor.setPassword(passwordEncoder.encode(password));
        return professorRepository.save(professor);
    }

    public StudentRepositoryModel registerStudent(String name, String email, String password) throws RoleNotFoundException {
        StudentRepositoryModel student = new StudentRepositoryModel();
        student.setName(name);
        student.setEmail(email);

        RoleRepositoryModel role = roleRepository.findById(4L).orElseThrow(() -> new RoleNotFoundException("Le rôle avec l'ID spécifié n'a pas été trouvé."));
        student.getRoles().add(role);

        student.setCredits(5);
        student.setPassword(passwordEncoder.encode(password));
        return studentRepository.save(student);
    }

//    public Map<String,Object> getUserDetail(OwnerRepositoryModel userForCast) {
//        Map<String,Object>user = new HashMap<>();
//        user.put("id",userForCast.getId());
//        user.put("name",userForCast.getName());
//        user.put("email",userForCast.getEmail());
//        user.put("roles",userForCast.getAuthorities().stream().map(value->value.getAuthority()).collect(Collectors.toList()));
//        return user;
//    }
}
