package com.simplon.coupdemaths.services.student.model;

import com.simplon.coupdemaths.repositories.response.ResponseRepositoryModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocResponseServiceModel {
    private Long id;
    private String documentName;
    private String documentPath;
    //private ResponseRepositoryModel response;
}
