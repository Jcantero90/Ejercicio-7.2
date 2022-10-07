package com.example.bosonit72.Estudiante_Asignatura.infrastructure.service;

import com.example.bosonit72.Estudiante_Asignatura.infrastructure.InputEstudianteAsignaturaDto.InputEstudianteAsignaturaDto;
import com.example.bosonit72.Estudiante_Asignatura.infrastructure.OutPutEStudianteAsignaturaDto.OutPutEstudianteAsignaturaDto;
import com.example.bosonit72.Estudiante_Asignatura.infrastructure.repository.EstudianteAsignaturaRepository;
import com.example.bosonit72.Exception.EntityNotFoundException;
import com.example.bosonit72.Persona.domain.Persona;
import com.example.bosonit72.Persona.infraestructure.controler.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteAsignaturaServiceImpl implements EstudianteAsignaturaService {

    @Autowired
    EstudianteAsignaturaRepository estudianteAsignaturaRepository;

    @Autowired
    PersonServiceImp personServiceImp;
    public OutPutEstudianteAsignaturaDto addStudent (InputEstudianteAsignaturaDto estudianteAsignaturaDto){

        if(estudianteAsignaturaDto.getId_student()==null) {
            throw new EntityNotFoundException("El estudiante no existe!");
        }
        if(estudianteAsignaturaDto.getId_teacher()==null){
            throw new EntityNotFoundException("El profesor no existe!");
        }



        return new OutPutEstudianteAsignaturaDto();
    }

}
