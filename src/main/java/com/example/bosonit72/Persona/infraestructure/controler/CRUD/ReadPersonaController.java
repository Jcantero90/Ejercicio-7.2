package com.example.bosonit72.Persona.infraestructure.controler.CRUD;

import com.example.bosonit72.Persona.domain.Persona;
import com.example.bosonit72.Persona.infraestructure.controler.OutPutPersonaDto.OutputPErsonaDTO;
import com.example.bosonit72.Persona.infraestructure.controler.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/SearchById{id}")
    public OutputPErsonaDTO getById(@PathVariable("id") Integer id) {
        return ex.findByIdPerosna(id);
    }


}
