package com.example.bosonit72.teacher.infrastructure.controller;

import com.example.bosonit72.teacher.domain.Teacher;
import com.example.bosonit72.teacher.infrastructure.OutPutProfesorDto.OutPutProfesorDto;
import com.example.bosonit72.teacher.infrastructure.OutPutProfesorDto.OutputProfesorNotFull;
import com.example.bosonit72.teacher.infrastructure.repository.TeacherRepository;
import com.example.bosonit72.teacher.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/profesor")
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
    public OutputProfesorNotFull findByIdNotFull(@PathVariable ("id") Integer id){
        return teacherServiceImpl.readByIdNotFull(id);
    }
    @GetMapping("/findTeacherNoValues")
    public OutPutProfesorDto findByID(){
        return teacherServiceImpl.readById(1);
    }

}
