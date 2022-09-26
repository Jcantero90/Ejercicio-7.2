package com.example.bosonit72.Persona.infraestructure.controler.CRUD;


import com.example.bosonit72.Persona.infraestructure.controler.InputPersonaDto.InputPerdonaDTO;
import com.example.bosonit72.Persona.infraestructure.controler.OutPutPersonaDto.OutputPErsonaDTO;
import com.example.bosonit72.Persona.infraestructure.controler.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreatePersonaController {

    @Autowired
    PersonServiceImp executable;

    @PostMapping("/addPersona")
    public OutputPErsonaDTO addPersona(@RequestBody InputPerdonaDTO personaDatos) throws Exception {
        return executable.addPersona(personaDatos);
    }
}
