package com.simplon.coupdemaths.controllers.doc;

import com.simplon.coupdemaths.repositories.doc.DocDiplomeRepositoryModel;
import com.simplon.coupdemaths.services.doc.DocDiplomeServiceModel;
import org.mapstruct.factory.Mappers;

public interface DocDiplomeMapper {
    DocDiplomeMapper INSTANCE = Mappers.getMapper(DocDiplomeMapper.class);

    // BDD to the Front
    DocDiplomeServiceModel repoToService(DocDiplomeRepositoryModel docDiplomeRepositoryModel);
    DocDiplomeDto serviceToDto(DocDiplomeServiceModel docDiplomeServiceModel);
}
