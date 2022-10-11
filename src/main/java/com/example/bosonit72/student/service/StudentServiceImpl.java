package com.example.bosonit72.student.service;

import com.example.bosonit72.exception.EntityNotFoundException;
import com.example.bosonit72.person.domain.Persona;
import com.example.bosonit72.person.infraestructure.controler.repository.PersonRepository;
import com.example.bosonit72.student.domain.Student;
import com.example.bosonit72.student.infrastructure.inputStudentsDto.InputStudentsDto;
import com.example.bosonit72.student.infrastructure.repository.StudentRepository;
import com.example.bosonit72.student.infrastructure.outputStudentsDto.OutPutStudentsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonRepository personRepository;


    @Override
    public OutPutStudentsDto addStudent(InputStudentsDto studentDto) throws Exception{

        Optional<Persona> personaOpt = personRepository.findById(studentDto.getId_persona());
        Persona persona = personaOpt.get();

        if(persona==null){
            throw new EntityNotFoundException("Persona no encontrada");
        }
        if(persona.getStudent()!=null){
            throw new EntityNotFoundException("Esta persona es un estudiante!");
        }
        if(persona.getTeacher()!=null){
            throw new EntityNotFoundException("El usuario es un profesor!");
        }

        Student student = new Student(studentDto);
        student.setPersona(persona);
        studentRepository.save(student);
        return new OutPutStudentsDto(student);
    }

    @Override
    public OutPutStudentsDto updateStudent(Integer id, InputStudentsDto studentDto) {
        Optional<Student> updateStudent = studentRepository.findById(id);
        Student st1 = updateStudent.get();
        st1.setNum_hours_week(studentDto.getNum_hours_week());
        st1.setComments(studentDto.getComments());
        st1.setBranch(studentDto.getBranch());
        studentRepository.save(st1);
    return new OutPutStudentsDto(st1);
    }
    public List<Student> findAll (){
        return studentRepository.findAll();
    }
    public OutPutStudentsDto getStudent(Integer id) {
        return new OutPutStudentsDto(studentRepository.findStudentById(id));
    }

    public OutPutStudentsDto.OutPutStudentsNotFullDto getNotFullStudent(Integer id) {
        return new OutPutStudentsDto.OutPutStudentsNotFullDto(studentRepository.findStudentById(id));
    }

    @Override
    public void deleteStudent(Integer id) {
    studentRepository.deleteById(id);
    }
}
