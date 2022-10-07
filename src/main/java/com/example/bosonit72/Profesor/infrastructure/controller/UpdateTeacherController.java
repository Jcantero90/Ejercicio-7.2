package com.example.bosonit72.Profesor.infrastructure.controller;

import com.example.bosonit72.Profesor.infrastructure.InputProfesorDto.InputProfesorDto;
import com.example.bosonit72.Profesor.infrastructure.OutPutProfesorDto.OutPutProfesorDto;
import com.example.bosonit72.Profesor.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateTeacherController {

    @Autowired
    TeacherServiceImpl teacherService;

    @PutMapping("/updateTeacher/{id}")
    public OutPutProfesorDto updateTeacher(@PathVariable("id") Integer id, @RequestBody InputProfesorDto profesorDto) {
        return teacherService.updateTeacher(id, profesorDto);
    }
}
