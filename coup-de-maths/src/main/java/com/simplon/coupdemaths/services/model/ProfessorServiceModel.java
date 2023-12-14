package com.simplon.coupdemaths.services.model;

import com.simplon.coupdemaths.repositories.doc.DocDiplomeRepositoryModel;
import com.simplon.coupdemaths.repositories.response.ResponseRepositoryModel;
import com.simplon.coupdemaths.repositories.transaction.TransactionRepositoryModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ProfessorServiceModel {
    private Long id;
    private String name;
    private String email;
    private String password;
    private int credits;
    //private List<ResponseServiceModel> responses = new ArrayList<>();
    //private List<TransactionServiceModel> transactions = new ArrayList<>();
    //private List<DocDiplomeServiceModel> docDiplomes = new ArrayList<>();
}
