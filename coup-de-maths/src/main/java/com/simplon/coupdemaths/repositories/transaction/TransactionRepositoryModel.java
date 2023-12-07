package com.simplon.coupdemaths.repositories.transaction;

import com.simplon.coupdemaths.repositories.professor.ProfessorRepositoryModel;
import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "transaction")
public class TransactionRepositoryModel {
    // Unique identifier for the transaction
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Date and time when the transaction occurred
    @Column(name = "date")
    private LocalDateTime transactionDate;

    // Type of the transaction (e.g., credit purchase, payment)
    @Column(name = "type")
    private String transactionType;

    // Amount associated with the transaction
    @Column(name = "amount")
    private float amount;

    // Student involved in the transaction
    @ManyToOne
    @JoinColumn(name = "student_id",
            foreignKey = @jakarta.persistence
                    .ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private StudentRepositoryModel student;

    // Professor involved in the transaction
    @ManyToOne
    @JoinColumn(name = "professor_id", foreignKey = @jakarta.persistence
            .ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private ProfessorRepositoryModel professor;

    // PrePersist method to set the transaction date before persisting in the database
    @PrePersist
    public void prePersist() {
        this.transactionDate = LocalDateTime.now();
    }
}
