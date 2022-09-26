package com.example.bosonit72.Persona.infraestructure.controler.CRUD;

import com.example.bosonit72.Persona.domain.Persona;
import com.example.bosonit72.Persona.infraestructure.controler.OutPutPersonaDto.OutputPErsonaDTO;
import com.example.bosonit72.Persona.infraestructure.controler.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UpdatePersonaController {

    @Autowired
    PersonServiceImp ex;

    @PutMapping("/update{id}")
    public OutputPErsonaDTO updatePersona(@PathVariable("id") Integer id, @RequestBody Persona newPersona) {
        return ex.updatePersona(id, newPersona);
    }
}


