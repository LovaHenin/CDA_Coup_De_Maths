package com.simplon.coupdemaths.repositories.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface QuestionRepository extends JpaRepository<QuestionRepositoryModel,Long> {
    ArrayList<QuestionRepositoryModel> findAll();
    QuestionRepositoryModel save(QuestionRepositoryModel questionRepositoryModel);
}
