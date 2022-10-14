package com.example.bosonit72.subject.infrastructure.OutPutEStudianteAsignaturaDto;

import com.example.bosonit72.subject.domain.Estudiante_Asignatura;
import com.example.bosonit72.student.infrastructure.outputStudentsDto.OutPutStudentsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutPutEstudianteAsignaturaDto extends OutPutEstudiantesAsignaturaDtoPadre{

    private OutPutStudentsDto outPutStudentsDto;

    private String asignatura;

    private String coments;

    private Date initial_date;

    private Date finisth_date;

    public OutPutEstudianteAsignaturaDto(Estudiante_Asignatura estudiante_asignatura){

     setAsignatura(estudiante_asignatura.getAsignatura());
     setComents(estudiante_asignatura.getComents());
     setOutPutStudentsDto(new OutPutStudentsDto(estudiante_asignatura.getStudent()));
     setFinisth_date(estudiante_asignatura.getFinisth_date());
     setInitial_date(estudiante_asignatura.getInitial_date());
    }

}
