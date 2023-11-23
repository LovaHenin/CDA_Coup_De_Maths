package com.simplon.coupdemaths.controllers.doc;

import com.simplon.coupdemaths.repositories.doc.DocResponseRepositoryModel;
import com.simplon.coupdemaths.services.doc.DocResponseServiceModel;
import org.mapstruct.factory.Mappers;

public interface DocResponseMapper {
    DocResponseMapper INSTANCE = Mappers.getMapper(DocResponseMapper.class);

    // BDD to the Front
    DocResponseServiceModel repoToService(DocResponseRepositoryModel docResponseRepositoryModel);
    DocResponseDto serviceToDto(DocResponseServiceModel docResponseServiceModel);
}
