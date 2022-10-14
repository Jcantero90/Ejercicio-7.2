package com.example.bosonit72.subject.domain;


import com.example.bosonit72.subject.infrastructure.InputEstudianteAsignaturaDto.InputEstudianteAsignaturaDto;
import com.example.bosonit72.student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estudios")
public class Estudiante_Asignatura implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id_study;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    Student student;

    private String asignatura;//Ejemplo: HTML, Angular, SpringBoot...

    private String coments;//

    @Column(nullable = false)
    private Date initial_date;//fecha inicio.

    private Date finisth_date;//fecha final.


    public Estudiante_Asignatura (InputEstudianteAsignaturaDto estudiante_asignatura){

        setAsignatura(estudiante_asignatura.getAsignatura());
        setComents(estudiante_asignatura.getComents());
        setInitial_date(estudiante_asignatura.getInitial_date());
        setFinisth_date(estudiante_asignatura.getFinisth_date());
    }

}
