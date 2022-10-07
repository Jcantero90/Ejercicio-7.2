package com.example.bosonit72.Estudiante_Asignatura.domain;


import com.example.bosonit72.Profesor.domain.Teacher;
import com.example.bosonit72.Students.domain.Student;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "estudios")
public class Estudiante_Asignatura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id_study;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    Teacher profesor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    Student student;

    private String asignatura;//Ejemplo: HTML, Angular, SpringBoot...

    private String coments;//aquí apunta con cuantas mujeres ha hecho el delicioso.

    @Column(nullable = false)
    private Date initial_date;//fecha en la que se estrena y hace el delicioso.

    private Date finisth_date;//fecha en la que el estudiante termina de hacer el delicioso.

}
