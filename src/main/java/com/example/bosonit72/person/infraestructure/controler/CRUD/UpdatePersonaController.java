package com.example.bosonit72.person.infraestructure.controler.CRUD;

import com.example.bosonit72.person.domain.Persona;
import com.example.bosonit72.person.infraestructure.controler.OutPutPersonaDto.OutputPersonaDTO;
import com.example.bosonit72.person.application.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdatePersonaController {

    @Autowired
    PersonServiceImp ex;

    @PutMapping("/update{id}")
    public OutputPersonaDTO updatePersona(@PathVariable("id") Integer id_persona, @RequestBody Persona newPersona) {
        return ex.updatePersona(id_persona, newPersona);
    }
}



