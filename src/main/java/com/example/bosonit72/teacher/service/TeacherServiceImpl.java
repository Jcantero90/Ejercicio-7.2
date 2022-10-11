package com.example.bosonit72.teacher.service;

import com.example.bosonit72.exception.EntityNotFoundException;
import com.example.bosonit72.person.domain.Persona;
import com.example.bosonit72.person.application.service.PersonServiceImp;
import com.example.bosonit72.person.infraestructure.controler.repository.PersonRepository;
import com.example.bosonit72.teacher.domain.Teacher;
import com.example.bosonit72.teacher.infrastructure.InputProfesorDto.InputProfesorDto;
import com.example.bosonit72.teacher.infrastructure.OutPutProfesorDto.OutPutProfesorDto;
import com.example.bosonit72.teacher.infrastructure.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    PersonServiceImp personServiceImp;

    @Autowired
    PersonRepository personRepository;
    public OutPutProfesorDto postTeacher(InputProfesorDto profesorDto) throws Exception {

       Persona persona = personServiceImp.findById(profesorDto.getId_Persona());
     //  Persona persona = personRepository.findById(profesorDto.getId_Persona()).orElseThrow(()-> new EntityNotFoundException("Persona incorrecta"));



        if(persona==null){
            throw new EntityNotFoundException("Persona no encontrada");
        }
        if(persona.getStudent()!=null){
            throw new EntityNotFoundException("Esta persona es un estudiante!");
        }
        if(persona.getTeacher()!=null){
            throw new EntityNotFoundException("El usuario es un profesor!");
        }


        Teacher teacher = new Teacher(profesorDto);
        teacher.setPersona(persona);
        teacherRepository.save(teacher);
        return new OutPutProfesorDto(teacher);
//        return null;
    }

    public String deleteUser (Integer id){
        teacherRepository.deleteById(id);
    return "Profesor borrado";
    }

    public List<Teacher> readAll(){
        return teacherRepository.findAll();
    }

    public OutPutProfesorDto readById (Integer id){
         Optional<Teacher> teacher1 = teacherRepository.findById(id);
         Teacher teacher = teacher1.get();
    return new OutPutProfesorDto(teacher);
    }

    public OutPutProfesorDto.OutputProfesorNotFull readByIdNotFull(Integer id){
        Optional<Teacher> teacherDto = teacherRepository.findById(id);
        Teacher teacher = teacherDto.get();
        return new OutPutProfesorDto.OutputProfesorNotFull(teacher);
    }

    public OutPutProfesorDto updateTeacher(Integer id_profesor, InputProfesorDto profesorDto) throws EntityNotFoundException{

        //Profesor buscado por ID.
//        Teacher teacher = teacherRepository.findById(id_profesor).orElseThrow(()-> new EntityNotFoundException("El profesor no existe"));
//        Persona persona = personRepository.findById(profesorDto.getId_Persona()).orElseThrow(()-> new EntityNotFoundException("Persona incorrecta"));

        Optional<Persona> personaOpt = personRepository.findById(profesorDto.getId_Persona());
        Optional<Teacher> teacherOpt = teacherRepository.findById(id_profesor);
        Persona persona = personaOpt.get();
        Teacher teacher = teacherOpt.get();
     //   if (persona==null){
//            teacher.setComments(profesorDto.getComments());
//            teacher.setBranch(profesorDto.getBranch());
//            teacher.setPersona(persona);
//
//            teacherRepository.save(teacher);
       // }


        if(persona==null){
            throw new EntityNotFoundException("Persona no encontrada");
        }
        if(persona.getStudent()!=null){
            throw new EntityNotFoundException("Esta persona es un estudiante!");
        }
        if(persona.getTeacher()!=null){
            throw new EntityNotFoundException("El usuario es un profesor!");
        }


        teacher.setComments(profesorDto.getComments());
        teacher.setBranch(profesorDto.getBranch());
        teacher.setPersona(persona);
        teacherRepository.save(teacher);
        return new OutPutProfesorDto(teacher);
    }

}
