package com.simplon.coupdemaths.repositories.professor;

import com.simplon.coupdemaths.repositories.doc.DocDiplomeRepositoryModel;
import com.simplon.coupdemaths.repositories.response.ResponseRepositoryModel;
import com.simplon.coupdemaths.repositories.securiry.OwnerRepositoryModel;
import com.simplon.coupdemaths.repositories.transaction.TransactionRepositoryModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "owner_id")
@Table(name = "professor")
public class ProfessorRepositoryModel extends OwnerRepositoryModel {

    // Credits associated with the professor's account
    @Column(name = "credits")
    private int credits;

    // List of responses provided by the professor
    @OneToMany(mappedBy = "professor", orphanRemoval = true)
    private List<ResponseRepositoryModel> responses = new ArrayList<>();

    // List of transactions associated with the professor
    @OneToMany(mappedBy = "professor", orphanRemoval = true)
    private List<TransactionRepositoryModel> transactions = new ArrayList<>();

    // List of diploma documents associated with the professor
    @OneToMany(mappedBy = "professor", orphanRemoval = true)
    private List<DocDiplomeRepositoryModel> docDiplomes = new ArrayList<>();

}
