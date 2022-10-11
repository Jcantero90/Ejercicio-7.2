package com.example.bosonit72.subject.infrastructure.InputEstudianteAsignaturaDto;

import lombok.Data;

import java.util.Date;

@Data
public class InputEstudianteAsignaturaDto {


    private Integer id_student;

    private String asignatura;

    private String coments;

    private Date initial_date;

    private Date finisth_date;

}
