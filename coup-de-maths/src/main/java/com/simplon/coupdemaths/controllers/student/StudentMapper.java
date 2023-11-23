package com.simplon.coupdemaths.controllers.student;

import com.simplon.coupdemaths.repositories.student.StudentRepositoryModel;
import com.simplon.coupdemaths.services.student.StudentServiceModel;
import org.mapstruct.factory.Mappers;

public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    // BDD to the Front
    StudentServiceModel repoToService(StudentRepositoryModel studentRepositoryModel);
    StudentDto serviceToDto(StudentServiceModel studentServiceModel);
}
