package com.example.bosonit72.teacher.infrastructure.OutPutProfesorDto;

import com.example.bosonit72.teacher.domain.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputProfesorNotFull {
    private Integer id_teacher;
    private String comments;
    private String branch;


    public OutputProfesorNotFull(Teacher teacher) {
        setId_teacher(teacher.getId_profesor());
        setComments(teacher.getComments());
        setBranch(teacher.getBranch());
    }
}


