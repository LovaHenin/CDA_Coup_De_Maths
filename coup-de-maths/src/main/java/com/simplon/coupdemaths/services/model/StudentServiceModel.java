package com.simplon.coupdemaths.services.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StudentServiceModel {
    private Long id;
    private String name;
    private String email;
    private String password;
    private int credits;
    private List<QuestionServiceModel> questions ;
    private List<TransactionServiceModel> transactions ;
}
