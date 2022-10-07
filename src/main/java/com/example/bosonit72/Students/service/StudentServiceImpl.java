package com.example.bosonit72.Students.service;

import com.example.bosonit72.Exception.EntityNotFoundException;
import com.example.bosonit72.Exception.UnprocessableEntityException;
import com.example.bosonit72.Persona.domain.Persona;
import com.example.bosonit72.Persona.infraestructure.controler.service.PersonServiceImp;
import com.example.bosonit72.Persona.infraestructure.controler.service.repository.PersonRepository;
import com.example.bosonit72.Profesor.domain.Teacher;
import com.example.bosonit72.Profesor.infrastructure.repository.TeacherRepository;
import com.example.bosonit72.Students.domain.Student;
import com.example.bosonit72.Students.infrastructure.inputStudentsDto.InputStudentsDto;
import com.example.bosonit72.Students.infrastructure.repository.StudentRepository;
import com.example.bosonit72.Students.infrastructure.outputStudentsDto.OutPutStudentsDto;
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

    @Autowired
    TeacherRepository teacherRepository;


    @Override
    public OutPutStudentsDto addStudent(InputStudentsDto studentDto) throws Exception{

        //Persona persona = personServiceImp.findById(studentDto.getId_persona());
        Optional<Persona> personaOpt = personRepository.findById(studentDto.getId_persona());
        Persona persona = personaOpt.get();

        //checking if persona is present in student or Teacher.
//        Optional<Teacher> teacherOpt = teacherRepository.findByPerson(persona);
//        Optional<Student> studentOpt = studentRepository.findByPerson(persona);
//
//        if (teacherOpt.isPresent() || studentOpt.isPresent()){
//            throw new UnprocessableEntityException("Usuario ya asignado");
//        }

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
