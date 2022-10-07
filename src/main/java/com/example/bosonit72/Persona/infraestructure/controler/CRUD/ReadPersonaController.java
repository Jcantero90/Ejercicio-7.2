package com.example.bosonit72.Persona.infraestructure.controler.CRUD;

import com.example.bosonit72.Exception.EntityNotFoundException;
import com.example.bosonit72.Persona.domain.Persona;
import com.example.bosonit72.Persona.infraestructure.controler.OutPutPersonaDto.OutPutPersonaFatherDto;
import com.example.bosonit72.Persona.infraestructure.controler.OutPutPersonaDto.OutputPersonaDTO;
import com.example.bosonit72.Persona.infraestructure.controler.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReadPersonaController {
    @Autowired
    PersonServiceImp ex;

    @GetMapping("/searchAll")
    public List<Persona> findAll() {
        return ex.getAllPersonas();
    }

    @GetMapping("/SearchById/{id}")
    public OutputPersonaDTO getById(@PathVariable("id") Integer id_persona) throws Exception {
        return ex.findByIdPersona(id_persona);
    }

    @GetMapping("/searchComplete/{id}")
    public OutPutPersonaFatherDto getByIdPlusStudentOrTeacher(@PathVariable ("id") Integer id, @RequestParam String type) throws EntityNotFoundException {
        return ex.findByIdFather(id, type);
    }
}
