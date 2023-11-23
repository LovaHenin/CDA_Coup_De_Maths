package com.simplon.coupdemaths.controllers.transaction;

import com.simplon.coupdemaths.repositories.transaction.TransactionRepositoryModel;
import com.simplon.coupdemaths.services.transaction.TransactionServiceModel;
import org.mapstruct.factory.Mappers;

public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    // BDD to the Front
    TransactionServiceModel repoToService(TransactionRepositoryModel transactionRepositoryModel);
    TransactionDto serviceToDto(TransactionServiceModel transactionServiceModel);
}
