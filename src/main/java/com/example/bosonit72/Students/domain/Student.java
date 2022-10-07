package com.example.bosonit72.Students.domain;

import com.example.bosonit72.Persona.domain.Persona;
import com.example.bosonit72.Profesor.domain.Teacher;
import com.example.bosonit72.Students.infrastructure.inputStudentsDto.InputStudentsDto;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "students")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name="id_persona")
    Persona persona;

    @Column(nullable = false)
    private Integer num_hours_week;

    private String comments;

    @OneToOne
    @JoinColumn(name="id_profesor")
    private Teacher profesor;

    @Column(nullable = false)
    private String branch;// Rama principal delestudiante (Front, Back, FullStack)

    public Student (){
    }

    public Student(InputStudentsDto studentInputDTO) {
        setNum_hours_week(studentInputDTO.getNum_hours_week());
        setComments(studentInputDTO.getComments());
        setBranch(studentInputDTO.getBranch());
    }


}
