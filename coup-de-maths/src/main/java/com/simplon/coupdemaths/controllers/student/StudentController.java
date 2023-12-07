package com.simplon.coupdemaths.controllers.student;

import com.simplon.coupdemaths.controllers.student.dto.StudentDto;
import com.simplon.coupdemaths.mapper.FullMapper;
import com.simplon.coupdemaths.services.student.StudentService;
import com.simplon.coupdemaths.services.student.model.StudentServiceModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> findAll(){
        List<StudentServiceModel> studentServiceModels = studentService.getAll();
        List<StudentDto> studentDtos = studentServiceModels.stream().map(FullMapper.INSTANCE::studentServiceToStudentDto).collect(Collectors.toList());
       return studentDtos;
    }

    @GetMapping("{id}")
    public StudentDto findById(@PathVariable("id") Long id){
        StudentServiceModel studentServiceModel = studentService.findById(id);
        StudentDto student = FullMapper.INSTANCE.studentServiceToStudentDto(studentServiceModel);
        return student;
    }

    @PostMapping
    public boolean newStudent(@RequestBody StudentDto studentDto){
        StudentServiceModel studentServiceModel = FullMapper.INSTANCE.studentDtoToStudentService(studentDto);
        return studentService.insererStudent(studentServiceModel);
    }

}
