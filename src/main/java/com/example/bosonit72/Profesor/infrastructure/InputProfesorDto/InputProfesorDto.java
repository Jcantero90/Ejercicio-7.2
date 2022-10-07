package com.example.bosonit72.Profesor.infrastructure.InputProfesorDto;

import com.example.bosonit72.Profesor.domain.Teacher;
import com.example.bosonit72.Students.infrastructure.inputStudentsDto.InputStudentsDto;
import lombok.Data;

@Data
public class InputProfesorDto {

    private Integer id_profesor;

    private Integer id_Persona;

    private String comments;

    private String branch;

}
