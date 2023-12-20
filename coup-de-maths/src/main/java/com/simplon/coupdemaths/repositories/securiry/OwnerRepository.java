package com.simplon.coupdemaths.repositories.securiry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OwnerRepository extends CrudRepository<OwnerRepositoryModel, Long> {
//    OwnerRepositoryModel findByLogin(String login);
    OwnerRepositoryModel findByEmail(String email);
}
