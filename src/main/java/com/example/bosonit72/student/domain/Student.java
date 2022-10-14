package com.example.bosonit72.student.domain;

import com.example.bosonit72.person.domain.Persona;
import com.example.bosonit72.teacher.domain.Teacher;
import com.example.bosonit72.student.infrastructure.inputStudentsDto.InputStudentsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name="id_profesor")
    private Teacher profesor;

    @Column(nullable = false)
    private String branch;// Rama principal delestudiante (Front, Back, FullStack)

    public Student(InputStudentsDto studentInputDTO) {
        setNum_hours_week(studentInputDTO.getNum_hours_week());
        setComments(studentInputDTO.getComments());
        setBranch(studentInputDTO.getBranch());
    }


}
