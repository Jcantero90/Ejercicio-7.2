package com.example.bosonit72.Students.infrastructure.crud;

import com.example.bosonit72.Students.domain.Student;
import com.example.bosonit72.Students.service.StudentServiceImpl;
import com.example.bosonit72.Students.infrastructure.outputStudentsDto.OutPutStudentsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReadStudentController   {
    @Autowired
    StudentServiceImpl studentServiceImpl;

    @GetMapping("/getStudentFull/{id}")
    public OutPutStudentsDto getStudent(@PathVariable ("id") Integer Id){
        return studentServiceImpl.getStudent(Id);
    }

    @GetMapping("/getStudent/{id}")
    public OutPutStudentsDto.OutPutStudentsNotFullDto getStudentSimple (@PathVariable ("id") Integer Id){
        return studentServiceImpl.getNotFullStudent(Id);
    }

    @GetMapping("/testStudents")
    public List<Student> findAll(){
        return studentServiceImpl.findAll();
    }

}
