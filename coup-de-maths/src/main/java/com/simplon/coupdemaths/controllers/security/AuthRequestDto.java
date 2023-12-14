package com.simplon.coupdemaths.controllers.security;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthRequestDto {
    private String name;
    private String email;
    private String password;
}





