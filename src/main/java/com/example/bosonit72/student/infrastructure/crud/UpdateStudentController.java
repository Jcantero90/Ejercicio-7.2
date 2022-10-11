package com.example.bosonit72.student.infrastructure.crud;

import com.example.bosonit72.student.service.StudentServiceImpl;
import com.example.bosonit72.student.infrastructure.inputStudentsDto.InputStudentsDto;
import com.example.bosonit72.student.infrastructure.outputStudentsDto.OutPutStudentsDto;
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
