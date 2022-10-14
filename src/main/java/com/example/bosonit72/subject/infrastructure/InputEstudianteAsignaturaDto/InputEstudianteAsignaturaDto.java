package com.example.bosonit72.subject.infrastructure.InputEstudianteAsignaturaDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputEstudianteAsignaturaDto {


    private Integer id_student;

    private String asignatura;

    private String coments;

    private Date initial_date;

    private Date finisth_date;

}
