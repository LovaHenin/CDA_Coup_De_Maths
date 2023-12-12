package com.simplon.coupdemaths.controllers.security;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

@Data
public class AuthResponseDto {
    private Map<String, Object> user = new HashMap<>();
    private String token;
    private String message;

    //LOGIN
    public AuthResponseDto(Map<String, Object> user, String token) {
        this.user = user;
        this.token = token;
    }

    public AuthResponseDto(String message) {
        this.message = message;
    }
}

