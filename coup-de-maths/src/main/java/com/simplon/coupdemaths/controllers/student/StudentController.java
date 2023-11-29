package com.simplon.coupdemaths.controllers.student;

import com.simplon.coupdemaths.dto.StudentDto;
import com.simplon.coupdemaths.mapper.CdmMapper;
import com.simplon.coupdemaths.services.student.StudentService;
import com.simplon.coupdemaths.services.student.StudentServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping
public List<StudentDto> findAll(){

   return studentService.getAll().stream().map(CdmMapper.INSTANCE::serviceToDto).collect(Collectors.toList());
}
@PostMapping
public  boolean newStudent(@RequestBody StudentDto studentDto){
        StudentServiceModel studentServiceModel =CdmMapper.INSTANCE.dtoToService(studentDto);
        return studentService.insererStudent(studentServiceModel);
}

}
