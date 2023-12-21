package com.simplon.coupdemaths.controllers.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDtoLight {
    private Long id;
    private String name;
    private String email;
//    private String password;
    private List<RoleDto> roles;
    private int credits;
}
