package com.simplon.coupdemaths.controllers.dto;

import com.simplon.coupdemaths.services.model.RoleServiceModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<RoleDto> roles;
    private int credits;
    private List<QuestionDto> questions ;
    private List<TransactionDto> transactions ;
}
