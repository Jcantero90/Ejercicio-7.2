package com.example.bosonit72.Profesor.service;

import com.example.bosonit72.Exception.EntityNotFoundException;
import com.example.bosonit72.Profesor.domain.Teacher;
import com.example.bosonit72.Profesor.infrastructure.InputProfesorDto.InputProfesorDto;
import com.example.bosonit72.Profesor.infrastructure.OutPutProfesorDto.OutPutProfesorDto;

import java.util.List;

public interface TeacherService {

    public OutPutProfesorDto postTeacher(InputProfesorDto profesorDto) throws Exception;

    public String deleteUser (Integer id);

    public List<Teacher> readAll();

    public OutPutProfesorDto readById (Integer id);

    public OutPutProfesorDto.OutputProfesorNotFull readByIdNotFull(Integer id);

    public OutPutProfesorDto updateTeacher(Integer id_profesor, InputProfesorDto profesorDto) throws EntityNotFoundException;

}




