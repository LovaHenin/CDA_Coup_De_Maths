package com.simplon.coupdemaths.controllers.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private int credits;
    private List<QuestionDto> questions ;
    private List<TransactionDto> transactions ;
}
