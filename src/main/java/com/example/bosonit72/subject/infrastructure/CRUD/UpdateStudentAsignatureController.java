package com.example.bosonit72.subject.infrastructure.CRUD;

import com.example.bosonit72.subject.infrastructure.InputEstudianteAsignaturaDto.InputEstudianteAsignaturaDto;
import com.example.bosonit72.subject.infrastructure.OutPutEStudianteAsignaturaDto.OutPutEstudiantesAsignaturaDtoPadre;
import com.example.bosonit72.subject.infrastructure.service.EstudianteAsignaturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateStudentAsignatureController {

    @Autowired
    EstudianteAsignaturaServiceImpl estudianteAsignaturaService;

    @PutMapping ("/updateStudnetAsignature/{id}")
    public OutPutEstudiantesAsignaturaDtoPadre updateAssignature(@PathVariable ("id") Integer id, @RequestBody InputEstudianteAsignaturaDto estudianteAsignaturaDto){
        return estudianteAsignaturaService.updateAssignature(id, estudianteAsignaturaDto);
    }
}
