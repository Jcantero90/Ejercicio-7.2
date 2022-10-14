package com.example.bosonit72.teacher.infrastructure.InputProfesorDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputProfesorDto {

    private Integer id_profesor;

    private Integer id_Persona;

    private String comments;

    private String branch;

}
