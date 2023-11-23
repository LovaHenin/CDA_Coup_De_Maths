package com.simplon.coupdemaths.services.doc;

import com.simplon.coupdemaths.services.response.ResponseServiceModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


@Data
@Service
@NoArgsConstructor
public class DocDiplomeServiceModel {

    // Unique identifier for the document
    private int id;

    // Name of the document
    private String documentName;

    // Path to the document
    private String documentPath;

    // Response associated with the document
    private ResponseServiceModel response;
}
