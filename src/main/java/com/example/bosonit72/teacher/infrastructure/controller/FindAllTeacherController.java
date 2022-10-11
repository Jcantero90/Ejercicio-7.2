package com.example.bosonit72.teacher.infrastructure.controller;

import com.example.bosonit72.teacher.domain.Teacher;
import com.example.bosonit72.teacher.infrastructure.OutPutProfesorDto.OutPutProfesorDto;
import com.example.bosonit72.teacher.infrastructure.repository.TeacherRepository;
import com.example.bosonit72.teacher.service.TeacherServiceImpl;
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
