package com.example.bosonit72.Students.infrastructure.crud;

import com.example.bosonit72.Students.service.StudentServiceImpl;
import com.example.bosonit72.Students.infrastructure.inputStudentsDto.InputStudentsDto;
import com.example.bosonit72.Students.infrastructure.outputStudentsDto.OutPutStudentsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateStudentController {

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @PutMapping("/updateStudent/{id}")
    public OutPutStudentsDto updateStudent(@PathVariable("id") Integer id, @RequestBody InputStudentsDto newStudent){
        return studentServiceImpl.updateStudent(id, newStudent);
    }
}
