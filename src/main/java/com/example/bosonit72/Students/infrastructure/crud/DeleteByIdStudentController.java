package com.example.bosonit72.Students.infrastructure.crud;

import com.example.bosonit72.Students.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteByIdStudentController {

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @DeleteMapping("/deleteStudent{id}")
    public String deleteStudent(@PathVariable ("id") Integer id){
        studentServiceImpl.deleteStudent(id);
        return "Student deleted";
    }
}
