package com.example.bosonit72.Students.infrastructure.inputStudentsDto;

import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
public class InputStudentsDto {

    private Integer id_persona;

    private Integer id_student;
    private Integer num_hours_week;

  //  private OutputPersonaDTO persona;
    private String comments;

    private String branch;
/*
    public Student TransformInputToStudent (Student student){
        Student student = new Student();

        student.setPersona(persona);
        student.setNum_hours_week(this.num_hours_week);
        student.setComments(this.comments);
        student.setBranch(this.branch);
        student.setProfesor(teacher);
        return student;


    }
 */





}
