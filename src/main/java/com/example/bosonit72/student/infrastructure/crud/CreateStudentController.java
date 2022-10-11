package com.example.bosonit72.student.infrastructure.crud;

import com.example.bosonit72.student.service.StudentServiceImpl;
import com.example.bosonit72.student.infrastructure.inputStudentsDto.InputStudentsDto;
import com.example.bosonit72.student.infrastructure.outputStudentsDto.OutPutStudentsDto;
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
