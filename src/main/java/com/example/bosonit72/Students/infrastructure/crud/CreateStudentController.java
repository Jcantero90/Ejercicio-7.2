package com.example.bosonit72.Students.infrastructure.crud;

import com.example.bosonit72.Students.service.StudentServiceImpl;
import com.example.bosonit72.Students.infrastructure.inputStudentsDto.InputStudentsDto;
import com.example.bosonit72.Students.infrastructure.outputStudentsDto.OutPutStudentsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateStudentController {
    @Autowired
    StudentServiceImpl studentService;

    @PostMapping("/addStudent")
    public OutPutStudentsDto addStudent (@RequestBody InputStudentsDto student) throws Exception {
        return studentService.addStudent(student);
    }
}
