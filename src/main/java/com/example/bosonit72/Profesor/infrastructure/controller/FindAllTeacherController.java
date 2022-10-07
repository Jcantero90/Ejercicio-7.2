package com.example.bosonit72.Profesor.infrastructure.controller;

import com.example.bosonit72.Profesor.domain.Teacher;
import com.example.bosonit72.Profesor.infrastructure.OutPutProfesorDto.OutPutProfesorDto;
import com.example.bosonit72.Profesor.infrastructure.repository.TeacherRepository;
import com.example.bosonit72.Profesor.service.TeacherServiceImpl;
import com.example.bosonit72.Students.infrastructure.outputStudentsDto.OutPutStudentsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindAllTeacherController {

    @Autowired
    TeacherServiceImpl teacherServiceImpl;

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/findTeacherAll")
    public List<Teacher> findAll(){
        return teacherServiceImpl.readAll();
    }

    @GetMapping("/findTeacher/{id}")
    public OutPutProfesorDto findById(@PathVariable ("id") Integer id){
        return teacherServiceImpl.readById(id);
    }

    @GetMapping("/findTeacherSiemple/{id}")
    public OutPutProfesorDto.OutputProfesorNotFull findByIdNotFull(@PathVariable ("id") Integer id){
        return teacherServiceImpl.readByIdNotFull(id);
    }
}
