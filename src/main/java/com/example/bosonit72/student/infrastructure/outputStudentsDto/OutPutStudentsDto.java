package com.example.bosonit72.student.infrastructure.outputStudentsDto;

import com.example.bosonit72.person.domain.Persona;
import com.example.bosonit72.teacher.infrastructure.OutPutProfesorDto.OutPutProfesorDto;
import com.example.bosonit72.student.domain.Student;
import lombok.Data;

@Data
public class OutPutStudentsDto {
    private Persona person;
    private Integer id_persona;
    private Integer id_student;
    private int num_hours_week;
    private String comments;
    private OutPutProfesorDto teacher;
    private String branch;

    public OutPutStudentsDto(Student student){
        setId_persona(student.getPersona().getId_persona());
        setId_student(student.getId());
        setNum_hours_week(student.getNum_hours_week());
        setPerson(student.getPersona());
        setComments(student.getComments());
        setTeacher(student.getProfesor() != null ? new OutPutProfesorDto(student.getProfesor()) : null);
        setBranch(student.getBranch());
    }

    @Data
    public static class OutPutStudentsNotFullDto {

        private Integer id_student;
        private int num_hours_week;
        private String comments;
        private String branch;

        public OutPutStudentsNotFullDto(Student student){

            setId_student(student.getId());
            setNum_hours_week(student.getNum_hours_week());
            setComments(student.getComments());
            setBranch(student.getBranch());
        }

        public OutPutStudentsNotFullDto(){}
    }
}
