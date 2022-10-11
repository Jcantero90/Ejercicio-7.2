package com.example.bosonit72.teacher.infrastructure.controller;

import com.example.bosonit72.teacher.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteTeacherByIdController {

    @Autowired
    TeacherServiceImpl teacherServiceImpl;

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable ("id") Integer id){
        return teacherServiceImpl.deleteUser(id);
    }
}
