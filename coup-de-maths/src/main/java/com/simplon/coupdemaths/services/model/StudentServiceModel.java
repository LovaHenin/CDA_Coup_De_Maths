package com.simplon.coupdemaths.services.model;

import com.simplon.coupdemaths.repositories.securiry.RoleRepositoryModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
public class StudentServiceModel {
    private Long id;
    private String name;
    private String email;
    private List<RoleServiceModel> roles;
    private String password;
    private int credits;
    private List<QuestionServiceModel> questions ;
    private List<TransactionServiceModel> transactions ;
}
