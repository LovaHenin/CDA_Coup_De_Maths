package com.simplon.coupdemaths.controllers.dto;

import com.simplon.coupdemaths.services.model.DocDiplomeServiceModel;
import com.simplon.coupdemaths.services.model.ResponseServiceModel;
import com.simplon.coupdemaths.services.model.TransactionServiceModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ProfessorDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private int credits;
//    private List<ResponseServiceModel> responses = new ArrayList<>();
//    private List<TransactionServiceModel> transactions = new ArrayList<>();
//    private List<DocDiplomeServiceModel> docDiplomes = new ArrayList<>();
}
