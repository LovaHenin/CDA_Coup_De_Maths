package com.simplon.coupdemaths.repositories.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StudentRepository extends JpaRepository<StudentRepositoryModel,Long> {
    //ArrayList<StudentRepositoryModel>findAll();
}
