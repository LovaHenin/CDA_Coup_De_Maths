package com.simplon.coupdemaths.controllers.student.dto;

import com.simplon.coupdemaths.services.student.model.QuestionServiceModel;
import com.simplon.coupdemaths.services.student.model.TransactionServiceModel;
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
