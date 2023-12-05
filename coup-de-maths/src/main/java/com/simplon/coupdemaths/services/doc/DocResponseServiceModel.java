package com.simplon.coupdemaths.services.doc;

import com.simplon.coupdemaths.services.response.ResponseServiceModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocResponseServiceModel {
    // Unique identifier for the document
    private Long id;

    // Name of the document
    private String documentName;

    // Path to the document
    private String documentPath;

    // Response associated with the document
    private ResponseServiceModel response;
}
