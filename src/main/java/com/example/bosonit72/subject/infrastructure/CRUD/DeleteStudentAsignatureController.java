package com.example.bosonit72.subject.infrastructure.CRUD;

import com.example.bosonit72.subject.infrastructure.service.EstudianteAsignaturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteStudentAsignatureController {

    @Autowired
    EstudianteAsignaturaServiceImpl estudianteAsignaturaService;

    @DeleteMapping ("/DeleteStudentAsignature/{id}")
    public String deleteAsignatureStudent (@PathVariable ("id") Integer id){
    return estudianteAsignaturaService.deleteAsignatura(id);
    }

}
