package com.example.bosonit72.Persona.infraestructure.controler.CRUD;


import com.example.bosonit72.Persona.infraestructure.controler.InputPersonaDto.InputPersonaDTO;
import com.example.bosonit72.Persona.infraestructure.controler.OutPutPersonaDto.OutputPersonaDTO;
import com.example.bosonit72.Persona.infraestructure.controler.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreatePersonaController {

    @Autowired
    PersonServiceImp ex;

    @PostMapping("/addPersona")
    public OutputPersonaDTO addPersona(@RequestBody InputPersonaDTO personaDatos) throws Exception {
        return ex.addPersona(personaDatos);
    }
}
