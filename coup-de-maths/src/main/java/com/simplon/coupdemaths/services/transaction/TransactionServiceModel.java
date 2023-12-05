package com.simplon.coupdemaths.services.transaction;

import com.simplon.coupdemaths.services.professor.ProfessorServiceModel;
import com.simplon.coupdemaths.services.student.StudentServiceModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TransactionServiceModel {
    // Unique identifier for the transaction
    private Long id;

    // Date and time when the transaction occurred
    private LocalDateTime transactionDate;

    // Type of the transaction (e.g., credit purchase, payment)
    private String transactionType;

    // Amount associated with the transaction
    private float amount;

    // Student involved in the transaction
    private StudentServiceModel student;

    // Professor involved in the transaction
    private ProfessorServiceModel professor;
}
