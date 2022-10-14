package com.example.bosonit72.person.infraestructure.controler.CRUD;

import com.example.bosonit72.exception.EntityNotFoundException;
import com.example.bosonit72.person.domain.Persona;
import com.example.bosonit72.person.infraestructure.controler.OutPutPersonaDto.OutPutPersonaFatherDto;
import com.example.bosonit72.person.infraestructure.controler.OutPutPersonaDto.OutputPersonaDTO;
import com.example.bosonit72.person.application.service.PersonServiceImp;
import com.example.bosonit72.teacher.infrastructure.OutPutProfesorDto.OutPutProfesorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ReadPersonaController {
    @Autowired
    PersonServiceImp personServiceImp;

    @GetMapping("/searchAll")
    public List<Persona> findAll() {
        return personServiceImp.getAllPersonas();
    }

    @GetMapping("/SearchById/{id}")
    public OutputPersonaDTO getById(@PathVariable("id") Integer id_persona) throws Exception {
        return personServiceImp.findByIdPersona(id_persona);
    }

    @GetMapping("/searchComplete/{id}")
    public OutPutPersonaFatherDto getByIdPlusStudentOrTeacher(@PathVariable ("id") Integer id, @RequestParam String type) throws EntityNotFoundException {
        return personServiceImp.findByIdFather(id, type);
    }

    @GetMapping("/feing/{id}")
    public OutPutProfesorDto getFeign(@PathVariable ("id") String id){
        return personServiceImp.getFeing(Integer.parseInt(id));
    }

}
