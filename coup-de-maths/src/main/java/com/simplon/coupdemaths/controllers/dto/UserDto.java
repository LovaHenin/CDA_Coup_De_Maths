package com.simplon.coupdemaths.controllers.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String username;
    private String password;
    private int credits;
    private Collection<? extends GrantedAuthority> getAuthorities;
}
