package com.simplon.coupdemaths.repositories.professor;

import com.simplon.coupdemaths.repositories.doc.DocDiplomeRepositoryModel;
import com.simplon.coupdemaths.repositories.response.ResponseRepositoryModel;
import com.simplon.coupdemaths.repositories.transaction.TransactionRepositoryModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "credits")
    private int credits;

    @OneToMany(mappedBy = "professor", orphanRemoval = true)
    private List<ResponseRepositoryModel> responses = new ArrayList<>();

    @OneToMany(mappedBy = "professor", orphanRemoval = true)
    private List<TransactionRepositoryModel> transactions = new ArrayList<>();

    @OneToMany(mappedBy = "professor", orphanRemoval = true)
    private List<DocDiplomeRepositoryModel> docDiplomes = new ArrayList<>();

}
