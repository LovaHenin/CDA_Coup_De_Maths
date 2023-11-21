package com.simplon.coupdemaths.repositories.transaction;

import com.simplon.coupdemaths.enums.TransactionTypeEnum;
import com.simplon.coupdemaths.repositories.professor.Professor;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name="transaction")
public class TransactionRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date")
    private LocalDateTime transactionDate;
    @Column(name = "type")
    private TransactionTypeEnum transactionType;
    @Column(name = "amount")
    private float amount;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentRepositoryModel student;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;


    @PrePersist
    public void prePersist(){
        this.transactionDate = LocalDateTime.now();
    }
}
