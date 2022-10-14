package com.example.bosonit72.subject.infrastructure.service;

import com.example.bosonit72.student.infrastructure.repository.StudentRepository;
import com.example.bosonit72.subject.domain.Estudiante_Asignatura;
import com.example.bosonit72.subject.infrastructure.InputEstudianteAsignaturaDto.InputEstudianteAsignaturaDto;
import com.example.bosonit72.subject.infrastructure.OutPutEStudianteAsignaturaDto.OutPutEstudianteAsignaturaDto;
import com.example.bosonit72.subject.infrastructure.OutPutEStudianteAsignaturaDto.OutPutEstudiantesAsignaturaDtoPadre;
import com.example.bosonit72.subject.infrastructure.repository.EstudianteAsignaturaRepository;
import com.example.bosonit72.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteAsignaturaServiceImpl implements EstudianteAsignaturaService {

    @Autowired
    EstudianteAsignaturaRepository estudianteAsignaturaRepository;

    @Autowired
    StudentRepository studentRepository;


   public OutPutEstudianteAsignaturaDto addStudent (InputEstudianteAsignaturaDto estudianteAsignaturaDto){

        if(estudianteAsignaturaDto.getId_student()==null) {
            throw new EntityNotFoundException("El estudiante no existe!");
        }

        Estudiante_Asignatura estudiante_asignatura = new Estudiante_Asignatura(estudianteAsignaturaDto);
        estudiante_asignatura.setStudent(studentRepository.findStudentById(estudianteAsignaturaDto.getId_student()));
        estudianteAsignaturaRepository.save(estudiante_asignatura);
        return new OutPutEstudianteAsignaturaDto(estudiante_asignatura);
    }

    public OutPutEstudiantesAsignaturaDtoPadre findStudentAssignatureById (Integer id){
       Optional<Estudiante_Asignatura> estudiante_asignaturaOpt = estudianteAsignaturaRepository.findById(id);
       Estudiante_Asignatura estudiante_asignatura = estudiante_asignaturaOpt.get();
       return new OutPutEstudianteAsignaturaDto(estudiante_asignatura);
    }

    public List<Estudiante_Asignatura> findStudentAssignatureByIdAllStudent (Integer id){

       List<Estudiante_Asignatura> list = estudianteAsignaturaRepository.findAll().stream().filter((p)->p.getStudent().getId().equals(id)).toList();
       return list;
   }

    public List<Estudiante_Asignatura> findAll (){
       return estudianteAsignaturaRepository.findAll();
    }

    public String deleteAsignatura (Integer id){
       estudianteAsignaturaRepository.deleteById(id);
        return "Asignatura borrada";
   }

   public OutPutEstudiantesAsignaturaDtoPadre updateAssignature (Integer id, InputEstudianteAsignaturaDto estudianteAsignaturaDto){
       Optional<Estudiante_Asignatura> estudiante_asignaturaUpd = estudianteAsignaturaRepository.findById(id);
       Estudiante_Asignatura estudiante_asignatura = estudiante_asignaturaUpd.get();
       estudiante_asignatura.setAsignatura(estudianteAsignaturaDto.getAsignatura());
       estudiante_asignatura.setComents(estudianteAsignaturaDto.getComents());
       estudiante_asignatura.setInitial_date(estudianteAsignaturaDto.getInitial_date());
       estudiante_asignatura.setFinisth_date(estudianteAsignaturaDto.getFinisth_date());
       estudianteAsignaturaRepository.save(estudiante_asignatura);
       return new OutPutEstudianteAsignaturaDto(estudiante_asignatura);
   }

}
