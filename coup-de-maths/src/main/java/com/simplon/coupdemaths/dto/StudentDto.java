package com.simplon.coupdemaths.dto;

public record StudentDto(
        Long id,
        String name,
        String email,
        String password,
        int credits

) {
}
