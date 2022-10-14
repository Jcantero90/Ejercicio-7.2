package com.example.bosonit72.subject.infrastructure.CRUD;

import com.example.bosonit72.subject.domain.Estudiante_Asignatura;
import com.example.bosonit72.subject.infrastructure.OutPutEStudianteAsignaturaDto.OutPutEstudiantesAsignaturaDtoPadre;
import com.example.bosonit72.subject.infrastructure.service.EstudianteAsignaturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class GetStudentAsignatureController {

    @Autowired
    EstudianteAsignaturaServiceImpl estudianteAsignaturaService;

    @GetMapping ("/getStudentAssignature/{id}")
    public OutPutEstudiantesAsignaturaDtoPadre getStudentsAssignature (@PathVariable ("id") Integer id){
        return estudianteAsignaturaService.findStudentAssignatureById(id);
    }

    @GetMapping ("/getStudentAssignatureAllStudents/{id}")
    public List<Estudiante_Asignatura> getStudentsAssignatureAllStudents (@PathVariable ("id") Integer id){
        return estudianteAsignaturaService.findStudentAssignatureByIdAllStudent(id);
    }
    @GetMapping ("/EstudianteAsignaturaTest")
    public List<Estudiante_Asignatura> getAllStudentsAssignature (){
        return estudianteAsignaturaService.findAll();
    }
}
