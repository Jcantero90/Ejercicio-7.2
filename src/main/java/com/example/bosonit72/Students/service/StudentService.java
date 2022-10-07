package com.example.bosonit72.Students.service;

import com.example.bosonit72.Students.infrastructure.inputStudentsDto.InputStudentsDto;
import com.example.bosonit72.Students.infrastructure.outputStudentsDto.OutPutStudentsDto;

public interface StudentService {

    OutPutStudentsDto addStudent(InputStudentsDto studentDto) throws Exception; //Post

    OutPutStudentsDto updateStudent(Integer id, InputStudentsDto studentDto);

    OutPutStudentsDto getStudent (Integer id);

    public OutPutStudentsDto.OutPutStudentsNotFullDto getNotFullStudent(Integer id);
    void deleteStudent(Integer id); //Delete

}
