package com.example.bosonit72.Persona.infraestructure.controler.CRUD;

import com.example.bosonit72.Persona.infraestructure.controler.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteByIdController {

    @Autowired
    PersonServiceImp ex;

    @DeleteMapping("/delete{id}")
    public String deleteByIdPersona(@PathVariable("id") Integer id) {
        ex.deleteByIdPersona(id);
        return "persona... borrada?";
    }
}
