package com.example.bosonit72.subject.infrastructure.CRUD;

import com.example.bosonit72.subject.infrastructure.InputEstudianteAsignaturaDto.InputEstudianteAsignaturaDto;
import com.example.bosonit72.subject.infrastructure.OutPutEStudianteAsignaturaDto.OutPutEstudianteAsignaturaDto;
import com.example.bosonit72.subject.infrastructure.service.EstudianteAsignaturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddStudentAsignatureController {

    @Autowired
    EstudianteAsignaturaServiceImpl estudianteAsignaturaImpl;

    @PostMapping("/AddAsignature")
    public OutPutEstudianteAsignaturaDto addAsignature (@RequestBody InputEstudianteAsignaturaDto estudianteAsignaturaDto){
        return estudianteAsignaturaImpl.addStudent(estudianteAsignaturaDto);
    }

}
