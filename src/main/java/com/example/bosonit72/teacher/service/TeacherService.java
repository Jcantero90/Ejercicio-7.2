package com.example.bosonit72.teacher.service;

import com.example.bosonit72.exception.EntityNotFoundException;
import com.example.bosonit72.teacher.domain.Teacher;
import com.example.bosonit72.teacher.infrastructure.InputProfesorDto.InputProfesorDto;
import com.example.bosonit72.teacher.infrastructure.OutPutProfesorDto.OutPutProfesorDto;

import java.util.List;

public interface TeacherService {

    public OutPutProfesorDto postTeacher(InputProfesorDto profesorDto) throws Exception;

    public String deleteUser (Integer id);

    public List<Teacher> readAll();

    public OutPutProfesorDto readById (Integer id);

    public OutPutProfesorDto.OutputProfesorNotFull readByIdNotFull(Integer id);

    public OutPutProfesorDto updateTeacher(Integer id_profesor, InputProfesorDto profesorDto) throws EntityNotFoundException;

}




