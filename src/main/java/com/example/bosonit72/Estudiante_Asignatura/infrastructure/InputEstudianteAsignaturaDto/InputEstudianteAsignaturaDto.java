package com.example.bosonit72.Estudiante_Asignatura.infrastructure.InputEstudianteAsignaturaDto;

import com.example.bosonit72.Estudiante_Asignatura.domain.Estudiante_Asignatura;
import com.example.bosonit72.Profesor.domain.Teacher;
import com.example.bosonit72.Students.domain.Student;
import lombok.Data;
import org.springframework.context.annotation.Profile;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class InputEstudianteAsignaturaDto {

    private Integer id_teacher;

    private Integer id_student;

    private String asignatura;

    private String coments;

    private Date initial_date;

    private Date finisth_date;
/*
    public Estudiante_Asignatura turnInputEstudianteAsignaturaToObject (Estudiante_Asignatura estudiante_asignatura){
        Estudiante_Asignatura estudianteCambiado = new Estudiante_Asignatura();
        estudianteCambiado.setAsignatura(this.asignatura);
        estudianteCambiado.setComents(this.coments);
        estudianteCambiado.setInitial_date(this.initial_date);
        estudianteCambiado.setFinisth_date(this.finisth_date);
        return estudianteCambiado;
    }
*/
}
