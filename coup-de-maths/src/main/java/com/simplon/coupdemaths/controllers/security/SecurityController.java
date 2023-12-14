package com.simplon.coupdemaths.controllers.security;


import com.simplon.coupdemaths.exceptions.AccountExistsException;
import com.simplon.coupdemaths.exceptions.UnauthorizedException;
import com.simplon.coupdemaths.repositories.professor.ProfessorRepository;
import com.simplon.coupdemaths.repositories.professor.ProfessorRepositoryModel;
import com.simplon.coupdemaths.repositories.securiry.OwnerRepositoryModel;
import com.simplon.coupdemaths.repositories.securiry.RoleRepository;
import com.simplon.coupdemaths.repositories.securiry.RoleRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepository;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import com.simplon.coupdemaths.services.professor.ProfessorService;
import com.simplon.coupdemaths.services.security.JwtUserService;
import com.simplon.coupdemaths.services.security.SecurityService;
import com.simplon.coupdemaths.services.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.RoleNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class SecurityController {

    @Autowired
    SecurityService securityService;
    @Autowired
    private JwtUserService userService;


    @PostMapping("/register/professor")
    public ResponseEntity<AuthResponseDto> registerProfessor(@RequestBody AuthRequestDto dto) throws RoleNotFoundException {
        // POST NEW PROFESSOR
        try {
            ProfessorRepositoryModel professor = securityService.registerProfessor(dto.getName(), dto.getEmail(), dto.getPassword());
            String token = userService.generateJwtForUser(professor);
            return ResponseEntity.ok(new AuthResponseDto(getUserDetail(professor), token));
        } catch (RoleNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AuthResponseDto("Erreur lors de l'enregistrement du professeur."));
        }
    }

    @PostMapping("/register/student")
    public ResponseEntity<AuthResponseDto> registerStudent(@RequestBody AuthRequestDto dto) {
        try {
            // POST NEW STUDENT
            StudentRepositoryModel student = securityService.registerStudent(dto.getName(), dto.getEmail(), dto.getPassword());
            String token = userService.generateJwtForUser(student);
            return ResponseEntity.ok(new AuthResponseDto( getUserDetail(student), token));
        } catch (RoleNotFoundException e) {
            // Gérer l'erreur lorsque le rôle n'est pas trouvé
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AuthResponseDto("Rôle non trouvé."));
        }
    }


    @PostMapping("/authorize")
    public ResponseEntity<AuthResponseDto> authorize(@RequestBody AuthRequestDto requestDto) throws UnauthorizedException {
        Authentication authentication = null;
        try {
            authentication = userService.authenticate(requestDto.getEmail(), requestDto.getPassword());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Get user
            UserDetails user = (UserDetails) authentication.getPrincipal();

            // Tester si l'objet est une instance de student ou professor
            Map<String,Object>userDetail;

            if (user instanceof StudentRepositoryModel) {
                // STUDENT
                System.out.println("StudentRepositoryModel");
                StudentRepositoryModel userCast = (StudentRepositoryModel) user;
                userDetail = getUserDetail(userCast);
            } else if (user instanceof ProfessorRepositoryModel) {
                // PROFESSOR
                System.out.println("ProfessorRepositoryModel");
                ProfessorRepositoryModel userCast = (ProfessorRepositoryModel) user;
                userDetail = getUserDetail(userCast);
            } else if (user instanceof OwnerRepositoryModel) {
                // ADMIN
                System.out.println("OwnerRepositoryModel");
                OwnerRepositoryModel userCast = (OwnerRepositoryModel) user;
                userDetail = getUserDetail(userCast);
            } else {
                throw new IllegalArgumentException("Type d'utilisateur inconnu : " + user.getClass());
            }

            // Token generation
            String token = userService.generateJwtForUser(user);
            // send response
            return ResponseEntity.ok(new AuthResponseDto(userDetail, token));

        } catch(AuthenticationException e) {
            throw new UnauthorizedException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String,Object> getUserDetail(OwnerRepositoryModel userForCast) {
        Map<String,Object>user = new HashMap<>();
        user.put("id",userForCast.getId());
        user.put("name",userForCast.getName());
        user.put("email",userForCast.getEmail());
        user.put("roles",userForCast.getAuthorities().stream().map(value->value.getAuthority()).collect(Collectors.toList()));
        return user;
    }
}


