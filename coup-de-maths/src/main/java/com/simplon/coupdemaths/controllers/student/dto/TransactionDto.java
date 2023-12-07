package com.simplon.coupdemaths.controllers.student.dto;

import com.simplon.coupdemaths.repositories.professor.ProfessorRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TransactionDto {
    private Long id;
    private LocalDateTime transactionDate;
    private String transactionType;
    private float amount;
    // private StudentRepositoryModel student;
    // private ProfessorRepositoryModel professor;
}
