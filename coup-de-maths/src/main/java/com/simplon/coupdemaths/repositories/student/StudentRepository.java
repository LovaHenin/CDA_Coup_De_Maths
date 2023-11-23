package com.simplon.coupdemaths.repositories.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface StudentRepository extends JpaRepository<StudentRepositoryModel,Long> {
    //ArrayList<StudentRepositoryModel>findAll();
}
