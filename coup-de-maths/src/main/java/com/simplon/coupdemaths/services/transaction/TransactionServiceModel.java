package com.simplon.coupdemaths.services.transaction;

import com.simplon.coupdemaths.enums.TransactionTypeEnum;
import com.simplon.coupdemaths.services.professor.ProfessorServiceModel;
import com.simplon.coupdemaths.services.student.StudentServiceModel;

import java.time.LocalDateTime;

public class TransactionServiceModel {
    // Unique identifier for the transaction
    private int id;

    // Date and time when the transaction occurred
    private LocalDateTime transactionDate;

    // Type of the transaction (e.g., credit purchase, payment)
    private TransactionTypeEnum transactionType;

    // Amount associated with the transaction
    private float amount;

    // Student involved in the transaction
    private StudentServiceModel student;

    // Professor involved in the transaction
    private ProfessorServiceModel professor;
}
