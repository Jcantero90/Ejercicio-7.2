package com.example.bosonit72.teacher.infrastructure.OutPutProfesorDto;

import com.example.bosonit72.person.infraestructure.controler.OutPutPersonaDto.OutputPersonaDTO;
import com.example.bosonit72.teacher.domain.Teacher;
import lombok.Data;

@Data
public class OutPutProfesorDto {
    private Integer id_teacher;
    private OutputPersonaDTO outputPErsonaDTO;
    private String comments;
    private String branch;

    public OutPutProfesorDto(Teacher teacher) {
        setId_teacher(teacher.getId_profesor());
        setOutputPErsonaDTO(new OutputPersonaDTO(teacher.getPersona()));
        setComments(teacher.getComments());
        setBranch(teacher.getBranch());
    }

    @Data
    public static class OutputProfesorNotFull {
        private Integer id_teacher;
        private String comments;
        private String branch;


        public OutputProfesorNotFull(Teacher teacher) {
            setId_teacher(teacher.getId_profesor());
            setComments(teacher.getComments());
            setBranch(teacher.getBranch());
        }
    }
}
