package com.simplon.coupdemaths.controllers.response;

import com.simplon.coupdemaths.repositories.response.ResponseRepositoryModel;
import com.simplon.coupdemaths.services.response.ResponseServiceModel;
import org.mapstruct.factory.Mappers;

public interface ResponseMapper {
    ResponseMapper INSTANCE = Mappers.getMapper(ResponseMapper.class);

    // BDD to the Front
    ResponseServiceModel repoToService(ResponseRepositoryModel responseRepositoryModel);
    ResponseDto serviceToDto(ResponseServiceModel responseServiceModel);
}
