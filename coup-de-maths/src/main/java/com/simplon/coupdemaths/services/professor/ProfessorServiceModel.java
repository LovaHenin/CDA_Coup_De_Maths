package com.simplon.coupdemaths.services.professor;

import com.simplon.coupdemaths.repositories.doc.DocDiplomeRepositoryModel;
import com.simplon.coupdemaths.repositories.response.ResponseRepositoryModel;
import com.simplon.coupdemaths.repositories.transaction.TransactionRepositoryModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@Service
@NoArgsConstructor
public class ProfessorServiceModel {

    // Unique identifier for the professor
    private int id;

    // Name of the professor
    private String name;

    // Email address of the professor
    private String email;

    // Password associated with the professor's account
    private String password;

    // Credits associated with the professor's account
    private int credits;

    // List of responses provided by the professor
    private List<ResponseRepositoryModel> responses ;

    // List of transactions associated with the professor
    private List<TransactionRepositoryModel> transactions ;

    // List of diploma documents associated with the professor
    private List<DocDiplomeRepositoryModel> docDiplomes ;
}
