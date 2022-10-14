package com.example.bosonit72.student.infrastructure.inputStudentsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputStudentsDto {

    private Integer id_persona;
    private Integer id_student;
    private Integer num_hours_week;
    private String comments;
    private String branch;






}
