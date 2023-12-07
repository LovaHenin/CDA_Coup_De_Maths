package com.simplon.coupdemaths.services.student.model;

import com.simplon.coupdemaths.repositories.professor.ProfessorRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TransactionServiceModel {
    private Long id;
    private LocalDateTime transactionDate;
    private String transactionType;
    private float amount;
    private StudentRepositoryModel student; // redondant si on viens de student
    private ProfessorRepositoryModel professor;
}
