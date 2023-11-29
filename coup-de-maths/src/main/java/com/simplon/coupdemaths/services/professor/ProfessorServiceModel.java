package com.simplon.coupdemaths.services.professor;


import com.simplon.coupdemaths.services.doc.DocDiplomeServiceModel;
import com.simplon.coupdemaths.services.response.ResponseServiceModel;
import com.simplon.coupdemaths.services.transaction.TransactionServiceModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@NoArgsConstructor
public class ProfessorServiceModel {

    // Unique identifier for the professor
    private Long id;

    // Name of the professor
    private String name;

    // Email address of the professor
    private String email;

    // Password associated with the professor's account
    private String password;

    // Credits associated with the professor's account
    private int credits;

    // List of responses provided by the professor
    private List<ResponseServiceModel> responses ;

    // List of transactions associated with the professor
    private List<TransactionServiceModel> transactions ;

    // List of diploma documents associated with the professor
    private List<DocDiplomeServiceModel> docDiplomes ;
}
