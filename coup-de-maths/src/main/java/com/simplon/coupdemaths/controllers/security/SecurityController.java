package com.simplon.coupdemaths.controllers.security;


import com.simplon.coupdemaths.exceptions.AccountExistsException;
import com.simplon.coupdemaths.exceptions.UnauthorizedException;
import com.simplon.coupdemaths.repositories.securiry.OwnerRepositoryModel;
import com.simplon.coupdemaths.services.professor.ProfessorService;
import com.simplon.coupdemaths.services.security.JwtUserService;
import com.simplon.coupdemaths.services.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SecurityController {
    @Autowired
    private JwtUserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ProfessorService professorService;


    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> register(@RequestBody AuthRequestDto dto) throws AccountExistsException {
        UserDetails user = userService.save(dto.getUsername(),
                dto.getPassword());

        // créer le lien vers student ou professor en recupérant l'id
        if (user instanceof OwnerRepositoryModel) {
            OwnerRepositoryModel u = (OwnerRepositoryModel) user;
            long userId = u.getId();
            System.out.println("User ID: " + userId);
            switch (dto.getRole()) {
                case 'STUDENT':
                    studentService.add();
                case 'PROFESSOR':

                case 'ADMIN':

            }
        } else {
            System.out.println("User is not an instance of User");
        }




        String token = userService.generateJwtForUser(user);
        return ResponseEntity.ok(new AuthResponseDto(user,token));
    }
//Remarque : ajouter un nouvel utilisateur et génère un JWT à la volée

    @PostMapping("/authorize")
    public ResponseEntity<AuthResponseDto> authorize(@RequestBody AuthRequestDto
                                                          requestDto) throws UnauthorizedException {
        Authentication authentication = null;
        try {
            authentication = userService.authenticate(requestDto.getUsername(),
                    requestDto.getPassword());
            SecurityContextHolder.getContext().setAuthentication(authentication);
// Token generation
            UserDetails user = (UserDetails) authentication.getPrincipal();
            String token = userService.generateJwtForUser(user);
            return ResponseEntity.ok(new AuthResponseDto(user, token));
        } catch(AuthenticationException e) {
            throw new UnauthorizedException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//Remarque: authentifie le principal (le user) à partir du JWT.
}


