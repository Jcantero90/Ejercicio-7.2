package com.example.bosonit72.Profesor.domain;

import com.example.bosonit72.Persona.domain.Persona;
import com.example.bosonit72.Persona.infraestructure.controler.InputPersonaDto.InputPersonaDTO;
import com.example.bosonit72.Profesor.infrastructure.InputProfesorDto.InputProfesorDto;
import com.example.bosonit72.Students.domain.Student;
import com.example.bosonit72.Students.infrastructure.inputStudentsDto.InputStudentsDto;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
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

    public Teacher(){}
}
