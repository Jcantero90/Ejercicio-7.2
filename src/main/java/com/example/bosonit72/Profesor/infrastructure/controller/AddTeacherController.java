package com.example.bosonit72.Profesor.infrastructure.controller;

import com.example.bosonit72.Exception.UnprocessableEntityException;
import com.example.bosonit72.Profesor.infrastructure.InputProfesorDto.InputProfesorDto;
import com.example.bosonit72.Profesor.infrastructure.OutPutProfesorDto.OutPutProfesorDto;
import com.example.bosonit72.Profesor.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddTeacherController {

    @Autowired
    TeacherServiceImpl teacherServiceImpl;

    @PostMapping("/addTeacher")
    public OutPutProfesorDto addStudent (@RequestBody InputProfesorDto profesorDto) throws Exception {
        return teacherServiceImpl.postTeacher(profesorDto);
    }
}
