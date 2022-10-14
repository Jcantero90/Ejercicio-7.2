package com.example.bosonit72.teacher.domain;

import com.example.bosonit72.person.domain.Persona;
import com.example.bosonit72.teacher.infrastructure.InputProfesorDto.InputProfesorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Profesor")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_profesor;

    @OneToOne
    @JoinColumn(name="id_persona")
    Persona persona;

    private String comments;

    @Column(nullable = false)
    private String branch;//Materia principal que imparte. Por ejemplo: Front

    public Teacher(InputProfesorDto profesorDto){
    //setPersona(studentsDto.getId_persona());
    setComments(profesorDto.getComments());
    setBranch(profesorDto.getBranch());
    }

}
